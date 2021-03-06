/*
 * Copyright 2020 Ren Binden
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

package com.rpkit.skills.bukkit.skills

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.skills.bukkit.RPKSkillsBukkit
import com.rpkit.skills.bukkit.database.table.RPKSkillBindingTable
import com.rpkit.skills.bukkit.database.table.RPKSkillCooldownTable
import org.bukkit.inventory.ItemStack


class RPKSkillProviderImpl(private val plugin: RPKSkillsBukkit): RPKSkillProvider {

    override val skills: MutableList<RPKSkill> = mutableListOf()

    override fun getSkill(name: String): RPKSkill? {
        return skills.firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    override fun addSkill(skill: RPKSkill) {
        skills.add(skill)
    }

    override fun removeSkill(skill: RPKSkill) {
        skills.remove(skill)
    }

    override fun getSkillCooldown(character: RPKCharacter, skill: RPKSkill): Int {
        val skillCooldownTable = plugin.core.database.getTable(RPKSkillCooldownTable::class)
        val skillCooldown = skillCooldownTable.get(character, skill) ?: return 0
        return Math.max(0, Math.ceil((skillCooldown.cooldownTimestamp - System.currentTimeMillis()) / 1000.0).toInt())
    }

    override fun setSkillCooldown(character: RPKCharacter, skill: RPKSkill, seconds: Int) {
        val skillCooldownTable = plugin.core.database.getTable(RPKSkillCooldownTable::class)
        var skillCooldown = skillCooldownTable.get(character, skill)
        if (skillCooldown == null) {
            skillCooldown = RPKSkillCooldown(
                    character = character,
                    skill = skill,
                    cooldownTimestamp = System.currentTimeMillis() + (seconds * 1000)
            )
            skillCooldownTable.insert(skillCooldown)
        } else {
            skillCooldown.cooldownTimestamp = System.currentTimeMillis() + (seconds * 1000)
            skillCooldownTable.update(skillCooldown)
        }
    }

    override fun getSkillBinding(character: RPKCharacter, item: ItemStack): RPKSkill? {
        val skillBindingTable = plugin.core.database.getTable(RPKSkillBindingTable::class)
        val skillBindings = skillBindingTable.get(character)
        return skillBindings.firstOrNull { skillBinding -> skillBinding.item.isSimilar(item) }?.skill
    }

    override fun setSkillBinding(character: RPKCharacter, item: ItemStack, skill: RPKSkill?) {
        val skillBindingTable = plugin.core.database.getTable(RPKSkillBindingTable::class)
        val skillBindings = skillBindingTable.get(character)
        if (skill != null) {
            if (skillBindings.none { skillBinding -> skillBinding.item.isSimilar(item) }) {
                skillBindingTable.insert(RPKSkillBinding(
                        character = character,
                        item = item,
                        skill = skill
                ))
            }
        } else {
            val skillBinding = skillBindings.firstOrNull { skillBinding -> skillBinding.item.isSimilar(item) }
            if (skillBinding != null) {
                skillBindingTable.delete(skillBinding)
            }
        }
    }

}