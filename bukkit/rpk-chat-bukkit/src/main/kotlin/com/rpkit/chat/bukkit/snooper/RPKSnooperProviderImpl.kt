/*
 * Copyright 2016 Ross Binden
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

package com.rpkit.chat.bukkit.snooper

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.database.table.RPKSnooperTable
import com.rpkit.players.bukkit.player.RPKPlayer

/**
 * Snooper provider implementation.
 */
class RPKSnooperProviderImpl(private val plugin: RPKChatBukkit): RPKSnooperProvider {

    override val snoopers: List<RPKPlayer>
        get() = plugin.core.database.getTable(RPKSnooperTable::class).getAll().map { snooper -> snooper.player }

    override fun addSnooper(player: RPKPlayer) {
        plugin.core.database.getTable(RPKSnooperTable::class).insert(RPKSnooper(player = player))
    }

    override fun removeSnooper(player: RPKPlayer) {
        val snooperTable = plugin.core.database.getTable(RPKSnooperTable::class)
        val snooper = snooperTable.get(player)
        if (snooper != null) {
            snooperTable.delete(snooper)
        }
    }

    override fun isSnooping(player: RPKPlayer): Boolean {
        val snooperTable = plugin.core.database.getTable(RPKSnooperTable::class)
        return snooperTable.get(player) != null
    }

}