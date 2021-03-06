/*
 * This file is generated by jOOQ.
 */
package com.rpkit.statbuilds.bukkit.database.jooq.rpkit;


import com.rpkit.statbuilds.bukkit.database.jooq.DefaultCatalog;
import com.rpkit.statbuilds.bukkit.database.jooq.rpkit.tables.RpkitCharacterStatPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Rpkit extends SchemaImpl {

    private static final long serialVersionUID = -1142691303;

    /**
     * The reference instance of <code>rpkit</code>
     */
    public static final Rpkit RPKIT = new Rpkit();

    /**
     * The table <code>rpkit.rpkit_character_stat_points</code>.
     */
    public final RpkitCharacterStatPoints RPKIT_CHARACTER_STAT_POINTS = RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS;

    /**
     * No further instances allowed
     */
    private Rpkit() {
        super("rpkit", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS);
    }
}
