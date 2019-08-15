/*
 * Copyright 2019 Ren Binden
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

/*
 * This file is generated by jOOQ.
 */
package com.rpkit.professions.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.professions.bukkit.database.jooq.rpkit.tables.RpkitCharacterProfessionChangeCooldown;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterProfessionChangeCooldownRecord extends UpdatableRecordImpl<RpkitCharacterProfessionChangeCooldownRecord> implements Record3<Integer, Integer, Timestamp> {

    private static final long serialVersionUID = -829564636;

    /**
     * Setter for <code>rpkit.rpkit_character_profession_change_cooldown.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_profession_change_cooldown.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_character_profession_change_cooldown.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_profession_change_cooldown.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_character_profession_change_cooldown.cooldown_end_time</code>.
     */
    public void setCooldownEndTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_profession_change_cooldown.cooldown_end_time</code>.
     */
    public Timestamp getCooldownEndTime() {
        return (Timestamp) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Timestamp> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Timestamp> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN.CHARACTER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN.COOLDOWN_END_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCharacterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getCooldownEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCharacterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCooldownEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterProfessionChangeCooldownRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterProfessionChangeCooldownRecord value2(Integer value) {
        setCharacterId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterProfessionChangeCooldownRecord value3(Timestamp value) {
        setCooldownEndTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterProfessionChangeCooldownRecord values(Integer value1, Integer value2, Timestamp value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitCharacterProfessionChangeCooldownRecord
     */
    public RpkitCharacterProfessionChangeCooldownRecord() {
        super(RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN);
    }

    /**
     * Create a detached, initialised RpkitCharacterProfessionChangeCooldownRecord
     */
    public RpkitCharacterProfessionChangeCooldownRecord(Integer id, Integer characterId, Timestamp cooldownEndTime) {
        super(RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN);

        set(0, id);
        set(1, characterId);
        set(2, cooldownEndTime);
    }
}