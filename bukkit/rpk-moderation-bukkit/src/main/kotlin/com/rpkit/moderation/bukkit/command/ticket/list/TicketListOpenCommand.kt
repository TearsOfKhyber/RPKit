/*
 * Copyright 2018 Ross Binden
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

package com.rpkit.moderation.bukkit.command.ticket.list

import com.rpkit.moderation.bukkit.RPKModerationBukkit
import com.rpkit.moderation.bukkit.ticket.RPKTicketProvider
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.time.format.DateTimeFormatter


class TicketListOpenCommand(private val plugin: RPKModerationBukkit): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission("rpkit.moderation.command.ticket.list.open")) {
            sender.sendMessage(plugin.messages["no-permission-ticket-list-open"])
        }
        val ticketProvider = plugin.core.serviceManager.getServiceProvider(RPKTicketProvider::class)
        val openTickets = ticketProvider.getOpenTickets()
        sender.sendMessage(plugin.messages["ticket-list-title"])
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        openTickets.forEach { ticket ->
            val closeDate = ticket.closeDate
            sender.sendMessage(plugin.messages["ticket-list-item", mapOf(
                    Pair("id", ticket.id.toString()),
                    Pair("reason", ticket.reason),
                    Pair("location", "${ticket.location?.world} ${ticket.location?.blockX}, ${ticket.location?.blockY}, ${ticket.location?.blockZ}"),
                    Pair("issuer", ticket.issuer.name),
                    Pair("resolver", ticket.resolver?.name?:"none"),
                    Pair("open-date", dateTimeFormatter.format(ticket.openDate)),
                    Pair("close-date", if (closeDate == null) "none" else dateTimeFormatter.format(ticket.closeDate)),
                    Pair("closed", ticket.isClosed.toString())
            )])
        }
        return true
    }

}