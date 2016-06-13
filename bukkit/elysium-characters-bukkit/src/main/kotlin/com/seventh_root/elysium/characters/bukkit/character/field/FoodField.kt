package com.seventh_root.elysium.characters.bukkit.character.field

import com.seventh_root.elysium.api.character.CharacterCardField
import com.seventh_root.elysium.api.character.ElysiumCharacter

class FoodField: CharacterCardField {

    override val name = "food"
    override fun get(character: ElysiumCharacter): String {
        return character.foodLevel.toString()
    }

}