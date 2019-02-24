/*
 * This file is generated by jOOQ.
 */
package com.rpkit.stores.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitConsumablePurchase;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class RpkitConsumablePurchaseRecord extends UpdatableRecordImpl<RpkitConsumablePurchaseRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 118289112;

    /**
     * Setter for <code>rpkit.rpkit_consumable_purchase.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_consumable_purchase.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_consumable_purchase.purchase_id</code>.
     */
    public void setPurchaseId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_consumable_purchase.purchase_id</code>.
     */
    public Integer getPurchaseId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_consumable_purchase.remaining_uses</code>.
     */
    public void setRemainingUses(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_consumable_purchase.remaining_uses</code>.
     */
    public Integer getRemainingUses() {
        return (Integer) get(2);
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
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE.PURCHASE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE.REMAINING_USES;
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
        return getPurchaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getRemainingUses();
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
        return getPurchaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getRemainingUses();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitConsumablePurchaseRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitConsumablePurchaseRecord value2(Integer value) {
        setPurchaseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitConsumablePurchaseRecord value3(Integer value) {
        setRemainingUses(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitConsumablePurchaseRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitConsumablePurchaseRecord
     */
    public RpkitConsumablePurchaseRecord() {
        super(RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE);
    }

    /**
     * Create a detached, initialised RpkitConsumablePurchaseRecord
     */
    public RpkitConsumablePurchaseRecord(Integer id, Integer purchaseId, Integer remainingUses) {
        super(RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE);

        set(0, id);
        set(1, purchaseId);
        set(2, remainingUses);
    }
}