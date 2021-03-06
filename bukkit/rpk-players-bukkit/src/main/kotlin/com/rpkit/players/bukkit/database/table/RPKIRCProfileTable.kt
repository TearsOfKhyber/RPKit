/*
 * Copyright 2020 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.players.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.players.bukkit.RPKPlayersBukkit
import com.rpkit.players.bukkit.database.jooq.rpkit.Tables.RPKIT_IRC_PROFILE
import com.rpkit.players.bukkit.profile.*
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.jooq.impl.DSL.constraint
import org.jooq.impl.SQLDataType
import org.pircbotx.User


class RPKIRCProfileTable(database: Database, private val plugin: RPKPlayersBukkit): Table<RPKIRCProfile>(database, RPKIRCProfile::class) {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_irc_profile.id.enabled")) {
        database.cacheManager.createCache("rpk-players-bukkit.rpkit_irc_profile.id",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, RPKIRCProfile::class.java,
                        ResourcePoolsBuilder.heap(plugin.config.getLong("caching.rpkit_irc_profile.id.size"))))
    } else {
        null
    }

    override fun create() {
        database.create
                .createTableIfNotExists(RPKIT_IRC_PROFILE)
                .column(RPKIT_IRC_PROFILE.ID, SQLDataType.INTEGER.identity(true))
                .column(RPKIT_IRC_PROFILE.PROFILE_ID, SQLDataType.INTEGER)
                .column(RPKIT_IRC_PROFILE.NICK, SQLDataType.VARCHAR(256))
                .constraints(
                        constraint("pk_rpkit_irc_profile").primaryKey(RPKIT_IRC_PROFILE.ID)
                )
                .execute()
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "1.3.0")
        }
    }

    override fun insert(entity: RPKIRCProfile): Int {
        val profile = entity.profile
        database.create
                .insertInto(
                        RPKIT_IRC_PROFILE,
                        RPKIT_IRC_PROFILE.PROFILE_ID,
                        RPKIT_IRC_PROFILE.NICK
                )
                .values(
                        if (profile is RPKProfile) {
                            profile.id
                        } else {
                            null
                        },
                        entity.nick
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        cache?.put(id, entity)
        return id
    }

    override fun update(entity: RPKIRCProfile) {
        val profile = entity.profile
        database.create
                .update(RPKIT_IRC_PROFILE)
                .set(
                        RPKIT_IRC_PROFILE.PROFILE_ID,
                        if (profile is RPKProfile) {
                            profile.id
                        } else {
                            null
                        }
                )
                .set(RPKIT_IRC_PROFILE.NICK, entity.nick)
                .where(RPKIT_IRC_PROFILE.ID.eq(entity.id))
                .execute()
        cache?.put(entity.id, entity)
    }

    override fun get(id: Int): RPKIRCProfile? {
        if (cache?.containsKey(id) == true) {
            return cache.get(id)
        } else {
            val result = database.create
                    .select(
                            RPKIT_IRC_PROFILE.PROFILE_ID,
                            RPKIT_IRC_PROFILE.NICK
                    )
                    .from(RPKIT_IRC_PROFILE)
                    .where(RPKIT_IRC_PROFILE.ID.eq(id))
                    .fetchOne() ?: return null
            val profileProvider = plugin.core.serviceManager.getServiceProvider(RPKProfileProvider::class)
            val profileId = result.get(RPKIT_IRC_PROFILE.PROFILE_ID)
            val profile = if (profileId != null) {
                profileProvider.getProfile(profileId)
            } else {
                null
            } ?: RPKThinProfileImpl(result.get(RPKIT_IRC_PROFILE.NICK))
            val ircProfile = RPKIRCProfileImpl(
                    id,
                    profile,
                    result.get(RPKIT_IRC_PROFILE.NICK)
            )
            cache?.put(id, ircProfile)
            return ircProfile
        }
    }

    fun get(profile: RPKProfile): List<RPKIRCProfile> {
        val results = database.create
                .select(RPKIT_IRC_PROFILE.ID)
                .from(RPKIT_IRC_PROFILE)
                .where(RPKIT_IRC_PROFILE.PROFILE_ID.eq(profile.id))
                .fetch()
        return results.map { result ->
            get(result.get(RPKIT_IRC_PROFILE.ID))
        }.filterNotNull()
    }

    fun get(user: User): RPKIRCProfile? {
        val result = database.create
                .select(RPKIT_IRC_PROFILE.ID)
                .from(RPKIT_IRC_PROFILE)
                .where(RPKIT_IRC_PROFILE.NICK.eq(user.nick))
                .fetchOne() ?: return null
        return get(result.get(RPKIT_IRC_PROFILE.ID))
    }

    override fun delete(entity: RPKIRCProfile) {
        database.create
                .deleteFrom(RPKIT_IRC_PROFILE)
                .where(RPKIT_IRC_PROFILE.ID.eq(entity.id))
                .execute()
        cache?.remove(entity.id)
    }

}