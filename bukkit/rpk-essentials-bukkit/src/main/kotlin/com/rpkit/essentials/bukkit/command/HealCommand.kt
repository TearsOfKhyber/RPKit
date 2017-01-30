package com.rpkit.essentials.bukkit.command

import com.rpkit.essentials.bukkit.RPKEssentialsBukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCommand(private val plugin: RPKEssentialsBukkit) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender.hasPermission("rpkit.essentials.command.heal")) {
            var player: Player? = null
            if (sender is Player) {
                player = sender
            }
            if (args.isNotEmpty()) {
                if (plugin.server.getPlayer(args[0]) != null) {
                    player = plugin.server.getPlayer(args[0])
                }
            }
            if (player != null) {
                player.health = player.maxHealth
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.heal-notification")))
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.heal-valid"))
                        .replace("\$player", player.name))
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.heal-usage-console")))
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.no-permission-heal")))
        }
        return true
    }

}