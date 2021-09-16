package com.example.lostinsiberia.utils

class Player(name: String) {
    var name = name
    var inventory = Inventory()

    @JvmName("setInventory1")
    fun setInventory(i: Inventory?){
        if (i != null) {
            inventory = i
        }
    }

    /**
    val wood_efficiency = 1.0
    val stone_efficiency = 1.0
    val hunting_efficiency = 1.0
    **/
}
