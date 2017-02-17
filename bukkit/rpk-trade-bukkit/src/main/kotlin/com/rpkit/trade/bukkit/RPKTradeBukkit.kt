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

package com.rpkit.trade.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.trade.bukkit.listener.BlockBreakListener
import com.rpkit.trade.bukkit.listener.PlayerInteractListener
import com.rpkit.trade.bukkit.listener.SignChangeListener

/**
 * RPK trade plugin default implementation.
 */
class RPKTradeBukkit: RPKBukkitPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        // Migrate config 1.1 -> 1.2
        if (!config.isConfigurationSection("traders.minimum-price")) {
            val minimumPrice = config.getInt("traders.minimum-price")
            config.set("traders.minimum-price", null)
            config.set("traders.minimum-price.default", minimumPrice)
        }
        if (!config.isConfigurationSection("traders.maximum-price")) {
            val maximumPrice = config.getInt("traders.maximum-price")
            config.set("traders.maximum-price", null)
            config.set("traders.maximum-price.default", maximumPrice)
        }
        serviceProviders = arrayOf()
    }

    override fun registerListeners() {
        registerListeners(
                BlockBreakListener(this),
                SignChangeListener(this),
                PlayerInteractListener(this)
        )
    }

}