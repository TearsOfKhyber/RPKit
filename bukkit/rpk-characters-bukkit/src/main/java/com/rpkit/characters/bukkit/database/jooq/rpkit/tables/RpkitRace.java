/*
 * This file is generated by jOOQ.
*/
package com.rpkit.characters.bukkit.database.jooq.rpkit.tables;


import com.rpkit.characters.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.characters.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.records.RpkitRaceRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitRace extends TableImpl<RpkitRaceRecord> {

    private static final long serialVersionUID = 1457746910;

    /**
     * The reference instance of <code>rpkit.rpkit_race</code>
     */
    public static final RpkitRace RPKIT_RACE = new RpkitRace();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitRaceRecord> getRecordType() {
        return RpkitRaceRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_race.id</code>.
     */
    public final TableField<RpkitRaceRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_race.name</code>.
     */
    public final TableField<RpkitRaceRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "");

    /**
     * Create a <code>rpkit.rpkit_race</code> table reference
     */
    public RpkitRace() {
        this("rpkit_race", null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_race</code> table reference
     */
    public RpkitRace(String alias) {
        this(alias, RPKIT_RACE);
    }

    private RpkitRace(String alias, Table<RpkitRaceRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitRace(String alias, Table<RpkitRaceRecord> aliased, Field<?>[] parameters) {
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
    public Identity<RpkitRaceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_RACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitRaceRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_RACE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitRaceRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitRaceRecord>>asList(Keys.KEY_RPKIT_RACE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitRace as(String alias) {
        return new RpkitRace(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitRace rename(String name) {
        return new RpkitRace(name, null);
    }
}