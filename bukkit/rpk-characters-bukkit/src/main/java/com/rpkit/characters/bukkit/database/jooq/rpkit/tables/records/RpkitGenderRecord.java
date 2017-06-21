/*
 * This file is generated by jOOQ.
*/
package com.rpkit.characters.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.RpkitGender;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class RpkitGenderRecord extends UpdatableRecordImpl<RpkitGenderRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 721542375;

    /**
     * Setter for <code>rpkit.rpkit_gender.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_gender.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_gender.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_gender.name</code>.
     */
    public String getName() {
        return (String) get(1);
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
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitGender.RPKIT_GENDER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return RpkitGender.RPKIT_GENDER.NAME;
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitGenderRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitGenderRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitGenderRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitGenderRecord
     */
    public RpkitGenderRecord() {
        super(RpkitGender.RPKIT_GENDER);
    }

    /**
     * Create a detached, initialised RpkitGenderRecord
     */
    public RpkitGenderRecord(Integer id, String name) {
        super(RpkitGender.RPKIT_GENDER);

        set(0, id);
        set(1, name);
    }
}