package com.rpkit.players.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.players.bukkit.RPKPlayersBukkit
import com.rpkit.players.bukkit.database.jooq.rpkit.Tables.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST
import com.rpkit.players.bukkit.profile.*
import org.jooq.SQLDialect
import org.jooq.impl.DSL.constraint
import org.jooq.impl.SQLDataType
import org.jooq.util.sqlite.SQLiteDataType

class RPKMinecraftProfileLinkRequestTable(database: Database, private val plugin: RPKPlayersBukkit): Table<RPKMinecraftProfileLinkRequest>(database, RPKMinecraftProfileLinkRequest::class) {

    override fun create() {
        database.create
                .createTableIfNotExists(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                .column(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID, if (database.dialect == SQLDialect.SQLITE) SQLiteDataType.INTEGER.identity(true) else SQLDataType.INTEGER.identity(true))
                .column(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID, SQLDataType.INTEGER)
                .column(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID, SQLDataType.INTEGER)
                .constraints(
                        constraint("pk_rpkit_profile_link").primaryKey(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID)
                )
                .execute()
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "1.4.0")
        }
    }

    override fun insert(entity: RPKMinecraftProfileLinkRequest): Int {
        database.create
                .insertInto(
                        RPKIT_MINECRAFT_PROFILE_LINK_REQUEST,
                        RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID,
                        RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID
                )
                .values(
                        entity.profile.id,
                        entity.minecraftProfile.id
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        return id
    }

    override fun update(entity: RPKMinecraftProfileLinkRequest) {
        database.create
                .update(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                .set(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID, entity.profile.id)
                .set(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID, entity.minecraftProfile.id)
                .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID.eq(entity.id))
                .execute()
    }

    override fun get(id: Int): RPKMinecraftProfileLinkRequest? {
        val result = database.create
                .select(
                        RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID,
                        RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID
                )
                .from(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID.eq(id))
                .fetchOne() ?: return null
        val profileId = result[RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID]
        val profileProvider = plugin.core.serviceManager.getServiceProvider(RPKProfileProvider::class)
        val profile = profileProvider.getProfile(profileId)
        if (profile == null) {
            database.create
                    .deleteFrom(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                    .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID.eq(id))
                    .execute()
            return null
        }
        val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
        val minecraftProfileId = result[RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID]
        val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(minecraftProfileId)
        if (minecraftProfile == null) {
            database.create
                    .deleteFrom(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                    .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID.eq(id))
                    .execute()
            return null
        }
        return RPKMinecraftProfileLinkRequestImpl(
                id,
                profile,
                minecraftProfile
        )
    }

    fun get(minecraftProfile: RPKMinecraftProfile): List<RPKMinecraftProfileLinkRequest> {
        val results = database.create
                .select(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID)
                .from(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID.eq(minecraftProfile.id))
                .fetch()
        return results.map { result -> get(result.get(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID)) }
                .filterNotNull()
    }

    override fun delete(entity: RPKMinecraftProfileLinkRequest) {
        database.create
                .deleteFrom(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST)
                .where(RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID.eq(entity.id))
                .execute()
    }
}