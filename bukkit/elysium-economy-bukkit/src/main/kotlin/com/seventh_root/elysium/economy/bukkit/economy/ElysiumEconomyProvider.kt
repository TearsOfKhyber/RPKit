package com.seventh_root.elysium.economy.bukkit.economy

import com.seventh_root.elysium.characters.bukkit.character.ElysiumCharacter
import com.seventh_root.elysium.core.service.ServiceProvider
import com.seventh_root.elysium.economy.bukkit.ElysiumEconomyBukkit
import com.seventh_root.elysium.economy.bukkit.currency.ElysiumCurrency
import com.seventh_root.elysium.economy.bukkit.database.table.ElysiumWalletTable
import com.seventh_root.elysium.economy.bukkit.exception.NegativeBalanceException
import com.seventh_root.elysium.economy.bukkit.wallet.ElysiumWallet


class ElysiumEconomyProvider(val plugin: ElysiumEconomyBukkit): ServiceProvider {

    fun getBalance(character: ElysiumCharacter, currency: ElysiumCurrency): Int {
        return (plugin.core.database.getTable(com.seventh_root.elysium.economy.bukkit.wallet.ElysiumWallet::class.java) as ElysiumWalletTable).get(character, currency).balance
    }

    fun setBalance(character: ElysiumCharacter, currency: ElysiumCurrency, amount: Int) {
        if (amount < 0) throw NegativeBalanceException()
        val wallet = (plugin.core.database.getTable(ElysiumWallet::class.java) as ElysiumWalletTable).get(character, currency)
        wallet.balance = amount
        plugin.core.database.getTable(ElysiumWallet::class.java)!!.update(wallet)
    }

    fun transfer(from: ElysiumCharacter, to: ElysiumCharacter, currency: ElysiumCurrency, amount: Int) {
        setBalance(from, currency, getBalance(from, currency) - amount)
        setBalance(to, currency, getBalance(to, currency) + amount)
    }

    fun getRichestCharacters(currency: ElysiumCurrency, amount: Int): List<ElysiumCharacter> {
        return (plugin.core.database.getTable(ElysiumWallet::class.java) as ElysiumWalletTable).getTop(amount, currency)
    }

}