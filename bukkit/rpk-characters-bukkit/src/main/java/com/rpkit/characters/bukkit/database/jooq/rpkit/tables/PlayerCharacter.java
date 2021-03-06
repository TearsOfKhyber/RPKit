/*
 * This file is generated by jOOQ.
*/
package com.rpkit.characters.bukkit.database.jooq.rpkit.tables;


import com.rpkit.characters.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.characters.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.characters.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.records.PlayerCharacterRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayerCharacter extends TableImpl<PlayerCharacterRecord> {

    private static final long serialVersionUID = -1974132267;

    /**
     * The reference instance of <code>rpkit.player_character</code>
     */
    public static final PlayerCharacter PLAYER_CHARACTER = new PlayerCharacter();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlayerCharacterRecord> getRecordType() {
        return PlayerCharacterRecord.class;
    }

    /**
     * The column <code>rpkit.player_character.player_id</code>.
     */
    public final TableField<PlayerCharacterRecord, Integer> PLAYER_ID = createField("player_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.player_character.character_id</code>.
     */
    public final TableField<PlayerCharacterRecord, Integer> CHARACTER_ID = createField("character_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>rpkit.player_character</code> table reference
     */
    public PlayerCharacter() {
        this(DSL.name("player_character"), null);
    }

    /**
     * Create an aliased <code>rpkit.player_character</code> table reference
     */
    public PlayerCharacter(String alias) {
        this(DSL.name(alias), PLAYER_CHARACTER);
    }

    /**
     * Create an aliased <code>rpkit.player_character</code> table reference
     */
    public PlayerCharacter(Name alias) {
        this(alias, PLAYER_CHARACTER);
    }

    private PlayerCharacter(Name alias, Table<PlayerCharacterRecord> aliased) {
        this(alias, aliased, null);
    }

    private PlayerCharacter(Name alias, Table<PlayerCharacterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Rpkit.RPKIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PLAYER_CHARACTER_UK_PLAYER_CHARACTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PlayerCharacterRecord>> getKeys() {
        return Arrays.<UniqueKey<PlayerCharacterRecord>>asList(Keys.KEY_PLAYER_CHARACTER_UK_PLAYER_CHARACTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerCharacter as(String alias) {
        return new PlayerCharacter(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerCharacter as(Name alias) {
        return new PlayerCharacter(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerCharacter rename(String name) {
        return new PlayerCharacter(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerCharacter rename(Name name) {
        return new PlayerCharacter(name, null);
    }
}
