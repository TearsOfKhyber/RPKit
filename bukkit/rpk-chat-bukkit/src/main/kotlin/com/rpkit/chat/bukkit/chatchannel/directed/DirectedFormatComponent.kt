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

package com.rpkit.chat.bukkit.chatchannel.directed

import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.chatchannel.pipeline.DirectedChatChannelPipelineComponent
import com.rpkit.chat.bukkit.context.DirectedChatChannelMessageContext
import com.rpkit.chat.bukkit.prefix.RPKPrefixProvider
import com.rpkit.core.bukkit.util.closestChatColor
import com.rpkit.players.bukkit.profile.RPKProfile
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.configuration.serialization.SerializableAs

/**
 * Directed format component.
 * Formats messages for individual receivers of a message.
 */
@SerializableAs("DirectedFormatComponent")
class DirectedFormatComponent(private val plugin: RPKChatBukkit, val formatString: String): DirectedChatChannelPipelineComponent, ConfigurationSerializable {

    override fun process(context: DirectedChatChannelMessageContext): DirectedChatChannelMessageContext {
        val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
        val prefixProvider = plugin.core.serviceManager.getServiceProvider(RPKPrefixProvider::class)
        val senderProfile = context.senderProfile
        val senderMinecraftProfile = context.senderMinecraftProfile
        val receiver = context.receiverMinecraftProfile
        val receiverProfile = receiver.profile
        val senderCharacter = if (senderMinecraftProfile != null)
            characterProvider.getActiveCharacter(senderMinecraftProfile)
        else
            null
        val receiverCharacter = characterProvider.getActiveCharacter(receiver)
        val chatChannel = context.chatChannel
        var formattedMessage = ChatColor.translateAlternateColorCodes('&', formatString)
        if (formattedMessage.contains("\$message")) {
            formattedMessage = formattedMessage.replace("\$message", context.message)
        }
        if (formattedMessage.contains("\$sender-prefix")) {
            formattedMessage = if (senderProfile is RPKProfile) {
                formattedMessage.replace("\$sender-prefix", prefixProvider.getPrefix(senderProfile))
            } else {
                formattedMessage.replace("\$sender-prefix", "")
            }
        }
        if (formattedMessage.contains("\$sender-player")) {
            formattedMessage = formattedMessage.replace("\$sender-player", senderProfile.name)
        }
        if (formattedMessage.contains("\$sender-character")) {
            if (senderCharacter != null) {
                formattedMessage = formattedMessage.replace("\$sender-character", if (senderCharacter.isNameHidden) "(HIDDEN ${senderCharacter.name.hashCode()})" else senderCharacter.name)
            } else {
                context.isCancelled = true
            }
        }
        if (formattedMessage.contains("\$receiver-prefix")) {
            formattedMessage = if (receiverProfile is RPKProfile) {
                formattedMessage.replace("\$receiver-prefix", prefixProvider.getPrefix(receiverProfile))
            } else {
                formattedMessage.replace("\$receiver-prefix", "")
            }
        }
        if (formattedMessage.contains("\$receiver-player")) {
            formattedMessage = formattedMessage.replace("\$receiver-player", receiverProfile.name)
        }
        if (formattedMessage.contains("\$receiver-character")) {
            if (receiverCharacter != null) {
                formattedMessage = formattedMessage.replace("\$receiver-character", receiverCharacter.name)
            } else {
                context.isCancelled = true
            }
        }
        if (formattedMessage.contains("\$channel")) {
            formattedMessage = formattedMessage.replace("\$channel", chatChannel.name)
        }
        if (formattedMessage.contains("\$color") || formattedMessage.contains("\$colour")) {
            val chatColorString = chatChannel.color.closestChatColor().toString()
            formattedMessage = formattedMessage.replace("\$color", chatColorString).replace("\$colour", chatColorString)
        }
        context.message = formattedMessage
        return context
    }

    override fun serialize(): MutableMap<String, Any> {
        return mutableMapOf(
                Pair("format", formatString)
        )
    }

    companion object {
        @JvmStatic
        fun deserialize(serialized: MutableMap<String, Any>): DirectedFormatComponent {
            return DirectedFormatComponent(
                    Bukkit.getPluginManager().getPlugin("rpk-chat-bukkit") as RPKChatBukkit,
                    serialized["format"] as String
            )
        }
    }

}