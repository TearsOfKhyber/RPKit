package com.seventh_root.elysium.chat.bukkit.chatchannel

import com.seventh_root.elysium.chat.bukkit.ElysiumChatBukkit
import com.seventh_root.elysium.chat.bukkit.chatchannel.pipeline.IRCChatChannelPipelineComponent
import com.seventh_root.elysium.chat.bukkit.database.table.ElysiumChatChannelTable
import com.seventh_root.elysium.chat.bukkit.database.table.ChatChannelSpeakerTable
import com.seventh_root.elysium.core.service.ServiceProvider
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayer

class ElysiumChatChannelProvider(private val plugin: ElysiumChatBukkit): ServiceProvider {

    val chatChannels: Collection<ElysiumChatChannel>
        get() {
            return (plugin.core.database.getTable(ElysiumChatChannel::class.java) as ElysiumChatChannelTable).getAll()
        }

    fun getChatChannel(id: Int): ElysiumChatChannel? {
        return plugin.core.database.getTable(ElysiumChatChannel::class.java)!![id]
    }

    fun getChatChannel(name: String): ElysiumChatChannel? {
        return (plugin.core.database.getTable(ElysiumChatChannel::class.java) as ElysiumChatChannelTable).get(name)
    }

    fun addChatChannel(chatChannel: ElysiumChatChannel) {
        plugin.core.database.getTable(ElysiumChatChannel::class.java)!!.insert(chatChannel)
    }

    fun removeChatChannel(chatChannel: ElysiumChatChannel) {
        plugin.core.database.getTable(ElysiumChatChannel::class.java)!!.delete(chatChannel)
    }

    fun updateChatChannel(chatChannel: ElysiumChatChannel) {
        plugin.core.database.getTable(ElysiumChatChannel::class.java)!!.update(chatChannel)
    }

    fun getPlayerChannel(player: ElysiumPlayer): ElysiumChatChannel? {
        return (plugin.core.database.getTable(ChatChannelSpeaker::class.java) as? ChatChannelSpeakerTable)?.get(player)?.chatChannel as? ElysiumChatChannel
    }

    fun setPlayerChannel(player: ElysiumPlayer, channel: ElysiumChatChannel) {
        val oldChannel = getPlayerChannel(player)
        if (oldChannel != null) {
            oldChannel.removeSpeaker(player)
            updateChatChannel(oldChannel)
        }
        channel.addSpeaker(player)
        updateChatChannel(channel)
    }

    fun getChatChannelFromIRCChannel(ircChannel: String): ElysiumChatChannel? {
        for (channel in chatChannels) {
            val pipeline = channel.pipeline
            for (component in pipeline) {
                if (component is IRCChatChannelPipelineComponent) {
                    if (component.ircChannel == ircChannel) {
                        return channel
                    }
                }
            }
        }
        return null
    }

}