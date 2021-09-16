package com.example.lostinsiberia.utils

import java.util.*
import kotlin.collections.HashMap
import java.io.Serializable

class Inventory : Serializable {
    private val inventoryMaterial = HashMap<Material, Int>()
    private val inventoryCrafts = ArrayList<Craft>()

    fun getIM(): HashMap<Material, Int> {
        return inventoryMaterial
    }

    fun getIC(): ArrayList<Craft> {
        return inventoryCrafts
    }


    fun add(e : Any, q : Int? = null){
        if(e is Material && q != null){ //The quantity needs to be non null
            if(!inventoryMaterial.containsKey(e)) {
                inventoryMaterial[e] = q //Initialize a new entry to the map
            } else {
                inventoryMaterial[e] = inventoryMaterial[e]?.plus(q)!! //Incrementing the quantity
            }
        } else if (e is Craft && q == null){ //Don't need quantity for a craft
            inventoryCrafts.add(e)
        } else{
            throw error("Inventory error")
        }
    }

    fun remove(e : Any, q : Int = 1){
        if(e is Material){
            inventoryMaterial[e]?.minus(q)
        } else{
            throw error("Inventory error")
        }
    }
    
    override fun toString(): String {
        var str  = "Materials :\n"
        for(key in inventoryMaterial.keys){
            str += "${key.name} : ${inventoryMaterial[key]}\n"
        }
        for(craft in inventoryCrafts){
            str += "${craft.name}\n"
        }

        return str


    }
}
