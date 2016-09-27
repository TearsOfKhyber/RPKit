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

package com.seventh_root.elysium.chat.bukkit.chatchannel.context

import com.seventh_root.elysium.chat.bukkit.chatchannel.ElysiumChatChannel
import com.seventh_root.elysium.chat.bukkit.context.DirectedChatChannelMessageContext
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayer


class DirectedChatChannelMessageContextImpl(
        override val chatChannel: ElysiumChatChannel,
        override val sender: ElysiumPlayer,
        override val receiver: ElysiumPlayer,
        override var message: String,
        override var isCancelled: Boolean = false
) : DirectedChatChannelMessageContext