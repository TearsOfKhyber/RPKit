/*
 * This file is generated by jOOQ.
*/
package com.rpkit.classes.bukkit.database.jooq.rpkit;


import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.RpkitCharacterClass;
import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.RpkitClassExperience;
import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.records.RpkitCharacterClassRecord;
import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.records.RpkitClassExperienceRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RpkitCharacterClassRecord, Integer> IDENTITY_RPKIT_CHARACTER_CLASS = Identities0.IDENTITY_RPKIT_CHARACTER_CLASS;
    public static final Identity<RpkitClassExperienceRecord, Integer> IDENTITY_RPKIT_CLASS_EXPERIENCE = Identities0.IDENTITY_RPKIT_CLASS_EXPERIENCE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitCharacterClassRecord> KEY_RPKIT_CHARACTER_CLASS_PRIMARY = UniqueKeys0.KEY_RPKIT_CHARACTER_CLASS_PRIMARY;
    public static final UniqueKey<RpkitClassExperienceRecord> KEY_RPKIT_CLASS_EXPERIENCE_PRIMARY = UniqueKeys0.KEY_RPKIT_CLASS_EXPERIENCE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<RpkitCharacterClassRecord, Integer> IDENTITY_RPKIT_CHARACTER_CLASS = createIdentity(RpkitCharacterClass.RPKIT_CHARACTER_CLASS, RpkitCharacterClass.RPKIT_CHARACTER_CLASS.ID);
        public static Identity<RpkitClassExperienceRecord, Integer> IDENTITY_RPKIT_CLASS_EXPERIENCE = createIdentity(RpkitClassExperience.RPKIT_CLASS_EXPERIENCE, RpkitClassExperience.RPKIT_CLASS_EXPERIENCE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<RpkitCharacterClassRecord> KEY_RPKIT_CHARACTER_CLASS_PRIMARY = createUniqueKey(RpkitCharacterClass.RPKIT_CHARACTER_CLASS, "KEY_rpkit_character_class_PRIMARY", RpkitCharacterClass.RPKIT_CHARACTER_CLASS.ID);
        public static final UniqueKey<RpkitClassExperienceRecord> KEY_RPKIT_CLASS_EXPERIENCE_PRIMARY = createUniqueKey(RpkitClassExperience.RPKIT_CLASS_EXPERIENCE, "KEY_rpkit_class_experience_PRIMARY", RpkitClassExperience.RPKIT_CLASS_EXPERIENCE.ID);
    }
}
