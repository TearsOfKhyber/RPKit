/*
 * This file is generated by jOOQ.
*/
package com.rpkit.selection.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.selection.bukkit.database.jooq.rpkit.tables.RpkitSelection;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class RpkitSelectionRecord extends UpdatableRecordImpl<RpkitSelectionRecord> implements Record9<Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -1964039113;

    /**
     * Setter for <code>rpkit.rpkit_selection.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.world</code>.
     */
    public void setWorld(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.world</code>.
     */
    public String getWorld() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.x_1</code>.
     */
    public void setX_1(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.x_1</code>.
     */
    public Integer getX_1() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.y_1</code>.
     */
    public void setY_1(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.y_1</code>.
     */
    public Integer getY_1() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.z_1</code>.
     */
    public void setZ_1(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.z_1</code>.
     */
    public Integer getZ_1() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.x_2</code>.
     */
    public void setX_2(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.x_2</code>.
     */
    public Integer getX_2() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.y_2</code>.
     */
    public void setY_2(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.y_2</code>.
     */
    public Integer getY_2() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>rpkit.rpkit_selection.z_2</code>.
     */
    public void setZ_2(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_selection.z_2</code>.
     */
    public Integer getZ_2() {
        return (Integer) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitSelection.RPKIT_SELECTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitSelection.RPKIT_SELECTION.MINECRAFT_PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return RpkitSelection.RPKIT_SELECTION.WORLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return RpkitSelection.RPKIT_SELECTION.X_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return RpkitSelection.RPKIT_SELECTION.Y_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return RpkitSelection.RPKIT_SELECTION.Z_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return RpkitSelection.RPKIT_SELECTION.X_2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return RpkitSelection.RPKIT_SELECTION.Y_2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return RpkitSelection.RPKIT_SELECTION.Z_2;
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
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getWorld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getX_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getY_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getZ_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getX_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getY_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getZ_2();
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
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getWorld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getX_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getY_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getZ_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getX_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getY_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getZ_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value2(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value3(String value) {
        setWorld(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value4(Integer value) {
        setX_1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value5(Integer value) {
        setY_1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value6(Integer value) {
        setZ_1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value7(Integer value) {
        setX_2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value8(Integer value) {
        setY_2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord value9(Integer value) {
        setZ_2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelectionRecord values(Integer value1, Integer value2, String value3, Integer value4, Integer value5, Integer value6, Integer value7, Integer value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitSelectionRecord
     */
    public RpkitSelectionRecord() {
        super(RpkitSelection.RPKIT_SELECTION);
    }

    /**
     * Create a detached, initialised RpkitSelectionRecord
     */
    public RpkitSelectionRecord(Integer id, Integer minecraftProfileId, String world, Integer x_1, Integer y_1, Integer z_1, Integer x_2, Integer y_2, Integer z_2) {
        super(RpkitSelection.RPKIT_SELECTION);

        set(0, id);
        set(1, minecraftProfileId);
        set(2, world);
        set(3, x_1);
        set(4, y_1);
        set(5, z_1);
        set(6, x_2);
        set(7, y_2);
        set(8, z_2);
    }
}
