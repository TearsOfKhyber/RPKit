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

package com.seventh_root.elysium.payments.bukkit.command.payment

import com.seventh_root.elysium.characters.bukkit.character.ElysiumCharacterProvider
import com.seventh_root.elysium.payments.bukkit.ElysiumPaymentsBukkit
import com.seventh_root.elysium.payments.bukkit.group.ElysiumPaymentGroupProvider
import com.seventh_root.elysium.payments.bukkit.notification.ElysiumPaymentNotificationImpl
import com.seventh_root.elysium.payments.bukkit.notification.ElysiumPaymentNotificationProvider
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayerProvider
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.text.SimpleDateFormat
import java.util.*

/**
 * Payment kick command.
 * Kicks a character from a payment group.
 */
class PaymentKickCommand(private val plugin: ElysiumPaymentsBukkit): CommandExecutor {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz")
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender.hasPermission("elysium.payments.command.payment.kick")) {
            if (args.size > 1) {
                val paymentGroupProvider = plugin.core.serviceManager.getServiceProvider(ElysiumPaymentGroupProvider::class)
                val paymentGroup = paymentGroupProvider.getPaymentGroup(args[0])
                if (paymentGroup != null) {
                    val playerProvider = plugin.core.serviceManager.getServiceProvider(ElysiumPlayerProvider::class)
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(ElysiumCharacterProvider::class)
                    val bukkitPlayer = plugin.server.getPlayer(args[1])
                    val player = playerProvider.getPlayer(bukkitPlayer)
                    val character = characterProvider.getActiveCharacter(player)
                    if (character != null) {
                        paymentGroup.removeInvite(character)
                        paymentGroup.removeMember(character)
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.payment-kick-valid")))
                        val paymentNotificationProvider = plugin.core.serviceManager.getServiceProvider(ElysiumPaymentNotificationProvider::class)
                        val now = System.currentTimeMillis()
                        val notificationMessage = ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.payment-notification-kick"))
                                .replace("\$member", character.name)
                                .replace("\$group", paymentGroup.name)
                                .replace("\$date", dateFormat.format(Date(now)))
                        if (!(character.player?.bukkitPlayer?.isOnline?:false)) { // If offline
                            paymentNotificationProvider.addPaymentNotification(
                                    ElysiumPaymentNotificationImpl(
                                            group = paymentGroup,
                                            to = character,
                                            character = character,
                                            date = now,
                                            text = notificationMessage
                                    )
                            )
                        } else { // If online
                            character.player?.bukkitPlayer?.player?.sendMessage(notificationMessage)
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.payment-kick-invalid-character")))
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.payment-")))
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.payment-kick-usage")))
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.no-permission-payment-kick")))
        }
        return true
    }
}