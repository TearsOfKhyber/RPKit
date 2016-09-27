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

package com.seventh_root.elysium.auctions.bukkit.auction

import com.seventh_root.elysium.auctions.bukkit.bid.ElysiumBid
import com.seventh_root.elysium.characters.bukkit.character.ElysiumCharacter
import com.seventh_root.elysium.core.database.Entity
import com.seventh_root.elysium.economy.bukkit.currency.ElysiumCurrency
import org.bukkit.Location
import org.bukkit.inventory.ItemStack


interface ElysiumAuction: Entity {

    val item: ItemStack
    val currency: ElysiumCurrency
    val location: Location?
    val character: ElysiumCharacter
    val bids: List<ElysiumBid>
    val duration: Long
    val endTime: Long
    val startPrice: Int
    val buyOutPrice: Int?
    val noSellPrice: Int?
    val minimumBidIncrement: Int
    val isBiddingOpen: Boolean
    fun addBid(bid: ElysiumBid)
    fun openBidding()
    fun closeBidding()

}