package com.rpkit.experience.bukkit.database.table

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.experience.bukkit.RPKExperienceBukkit
import com.rpkit.experience.bukkit.database.jooq.rpkit.Tables.RPKIT_EXPERIENCE
import com.rpkit.experience.bukkit.experience.RPKExperienceValue
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.jooq.impl.DSL.constraint
import org.jooq.impl.SQLDataType


class RPKExperienceTable(database: Database, private val plugin: RPKExperienceBukkit) : Table<RPKExperienceValue>(database, RPKExperienceValue::class) {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_experience.id.enabled")) {
        database.cacheManager.createCache("rpk-experience-bukkit.rpkit_experience.id", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Int::class.javaObjectType, RPKExperienceValue::class.java,
                        ResourcePoolsBuilder.heap(plugin.config.getLong("caching.rpkit_experience.id.size"))).build())
    } else {
        null
    }

    private val characterCache = if (plugin.config.getBoolean("caching.rpkit_experience.character_id.enabled")) {
        database.cacheManager.createCache("rpk-experience-bukkit.rpkit_experience.character_id", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Int::class.javaObjectType, RPKExperienceValue::class.java,
                        ResourcePoolsBuilder.heap(plugin.config.getLong("caching.rpkit_experience.character_id.size"))).build())
    } else {
        null
    }

    override fun create() {
        database.create
                .createTableIfNotExists(RPKIT_EXPERIENCE)
                .column(RPKIT_EXPERIENCE.ID, SQLDataType.INTEGER.identity(true))
                .column(RPKIT_EXPERIENCE.CHARACTER_ID, SQLDataType.INTEGER)
                .column(RPKIT_EXPERIENCE.VALUE, SQLDataType.INTEGER)
                .constraints(
                        constraint("pk_rpkit_experience").primaryKey(RPKIT_EXPERIENCE.ID)
                )
                .execute()
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "1.2.0")
        }
    }

    override fun delete(entity: RPKExperienceValue) {
        database.create
                .deleteFrom(RPKIT_EXPERIENCE)
                .where(RPKIT_EXPERIENCE.ID.eq(entity.id))
                .execute()
        cache?.remove(entity.id)
        characterCache?.remove(entity.character.id)
    }

    override fun get(id: Int): RPKExperienceValue? {
        if (cache?.containsKey(id) == true) {
            return cache.get(id)
        } else {
            val result = database.create
                    .select(
                            RPKIT_EXPERIENCE.CHARACTER_ID,
                            RPKIT_EXPERIENCE.VALUE
                    )
                    .from(RPKIT_EXPERIENCE)
                    .where(RPKIT_EXPERIENCE.ID.eq(id))
                    .fetchOne()
            val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
            val characterId = result.get(RPKIT_EXPERIENCE.CHARACTER_ID)
            val character = characterProvider.getCharacter(characterId)
            if (character != null) {
                val experienceValue = RPKExperienceValue(
                        id,
                        character,
                        result.get(RPKIT_EXPERIENCE.VALUE)
                )
                cache?.put(id, experienceValue)
                characterCache?.put(characterId, experienceValue)
                return experienceValue
            } else {
                database.create
                        .deleteFrom(RPKIT_EXPERIENCE)
                        .where(RPKIT_EXPERIENCE.ID.eq(id))
                        .execute()
                characterCache?.remove(characterId)
                return null
            }
        }
    }

    fun get(character: RPKCharacter): RPKExperienceValue? {
        if (characterCache?.containsKey(character.id) == true) {
            return characterCache.get(character.id)
        } else {
            val result = database.create
                    .select(RPKIT_EXPERIENCE.ID)
                    .from(RPKIT_EXPERIENCE)
                    .where(RPKIT_EXPERIENCE.CHARACTER_ID.eq(character.id))
                    .fetchOne() ?: return null
            return get(result.get(RPKIT_EXPERIENCE.ID))
        }
    }

    override fun insert(entity: RPKExperienceValue): Int {
        database.create
                .insertInto(
                        RPKIT_EXPERIENCE,
                        RPKIT_EXPERIENCE.CHARACTER_ID,
                        RPKIT_EXPERIENCE.VALUE
                )
                .values(
                        entity.character.id,
                        entity.value
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        cache?.put(id, entity)
        characterCache?.put(entity.character.id, entity)
        return id
    }

    override fun update(entity: RPKExperienceValue) {
        database.create
                .update(RPKIT_EXPERIENCE)
                .set(RPKIT_EXPERIENCE.CHARACTER_ID, entity.character.id)
                .set(RPKIT_EXPERIENCE.VALUE, entity.value)
                .where(RPKIT_EXPERIENCE.ID.eq(entity.id))
                .execute()
        cache?.put(entity.id, entity)
        characterCache?.put(entity.character.id, entity)
    }

}