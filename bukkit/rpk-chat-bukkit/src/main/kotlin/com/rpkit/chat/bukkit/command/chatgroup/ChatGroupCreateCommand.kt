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

package com.rpkit.chat.bukkit.command.chatgroup

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.chatgroup.RPKChatGroupImpl
import com.rpkit.chat.bukkit.chatgroup.RPKChatGroupProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Chat group create command.
 * Creates a chat group.
 */
class ChatGroupCreateCommand(private val plugin: RPKChatBukkit): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender.hasPermission("rpkit.chat.command.chatgroup.create")) {
            if (args.isNotEmpty()) {
                if (sender is Player) {
                    val chatGroupProvider = plugin.core.serviceManager.getServiceProvider(RPKChatGroupProvider::class)
                    if (chatGroupProvider.getChatGroup(args[0]) == null) {
                        if (!args[0].startsWith("_pm_")) {
                            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                            val chatGroup = RPKChatGroupImpl(plugin = plugin, name = args[0])
                            val senderMinecraftProfile = minecraftProfileProvider.getMinecraftProfile(sender)
                            if (senderMinecraftProfile != null) {
                                chatGroupProvider.addChatGroup(chatGroup)
                                chatGroup.addMember(senderMinecraftProfile)
                                sender.sendMessage(plugin.messages["chat-group-create-valid", mapOf(
                                        Pair("group", chatGroup.name)
                                )])
                            } else {
                                sender.sendMessage(plugin.messages["no-minecraft-profile"])
                            }
                        } else {
                            sender.sendMessage(plugin.messages["chat-group-create-invalid-reserved"])
                        }
                    } else {
                        sender.sendMessage(plugin.messages["chat-group-create-invalid-taken"])
                    }
                } else {
                    sender.sendMessage(plugin.messages["not-from-console"])
                }
            } else {
                sender.sendMessage(plugin.messages["chat-group-create-usage"])
            }
        } else {
            sender.sendMessage(plugin.messages["no-permission-chat-group-create"])
        }
        return true
    }

}