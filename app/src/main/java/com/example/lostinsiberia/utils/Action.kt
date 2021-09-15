package com.example.lostinsiberia.utils

open class Action(name: String) {
    val name = name

    open fun addToPlayerInventory(p : Player){}

    override fun toString(): String {
        return name
    }

}

class ActionMaterial(name: String, material: Material, quantity:Int) : Action(name) {
    val material = material
    val quantity = quantity

    override fun addToPlayerInventory(p: Player){
        p.inventory.add(material, quantity)
    }

}

class ActionCraft(name: String, item: Craft) : Action(name) {
    val item = item

    override fun addToPlayerInventory(p: Player){
        p.inventory.add(item)
    }
}