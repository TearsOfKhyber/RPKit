/*
 * This file is generated by jOOQ.
 */
package com.rpkit.stores.bukkit.database.jooq.rpkit.tables;


import com.rpkit.stores.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.stores.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.stores.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.records.RpkitTimedStoreItemRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitTimedStoreItem extends TableImpl<RpkitTimedStoreItemRecord> {

    private static final long serialVersionUID = -1258798022;

    /**
     * The reference instance of <code>rpkit.rpkit_timed_store_item</code>
     */
    public static final RpkitTimedStoreItem RPKIT_TIMED_STORE_ITEM = new RpkitTimedStoreItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitTimedStoreItemRecord> getRecordType() {
        return RpkitTimedStoreItemRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_timed_store_item.id</code>.
     */
    public final TableField<RpkitTimedStoreItemRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_timed_store_item.store_item_id</code>.
     */
    public final TableField<RpkitTimedStoreItemRecord, Integer> STORE_ITEM_ID = createField("store_item_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_timed_store_item.duration</code>.
     */
    public final TableField<RpkitTimedStoreItemRecord, Long> DURATION = createField("duration", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>rpkit.rpkit_timed_store_item</code> table reference
     */
    public RpkitTimedStoreItem() {
        this(DSL.name("rpkit_timed_store_item"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_timed_store_item</code> table reference
     */
    public RpkitTimedStoreItem(String alias) {
        this(DSL.name(alias), RPKIT_TIMED_STORE_ITEM);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_timed_store_item</code> table reference
     */
    public RpkitTimedStoreItem(Name alias) {
        this(alias, RPKIT_TIMED_STORE_ITEM);
    }

    private RpkitTimedStoreItem(Name alias, Table<RpkitTimedStoreItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitTimedStoreItem(Name alias, Table<RpkitTimedStoreItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> RpkitTimedStoreItem(Table<O> child, ForeignKey<O, RpkitTimedStoreItemRecord> key) {
        super(child, key, RPKIT_TIMED_STORE_ITEM);
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
        return Arrays.<Index>asList(Indexes.RPKIT_TIMED_STORE_ITEM_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitTimedStoreItemRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_TIMED_STORE_ITEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitTimedStoreItemRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_TIMED_STORE_ITEM_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitTimedStoreItemRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitTimedStoreItemRecord>>asList(Keys.KEY_RPKIT_TIMED_STORE_ITEM_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItem as(String alias) {
        return new RpkitTimedStoreItem(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItem as(Name alias) {
        return new RpkitTimedStoreItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitTimedStoreItem rename(String name) {
        return new RpkitTimedStoreItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitTimedStoreItem rename(Name name) {
        return new RpkitTimedStoreItem(name, null);
    }
}
