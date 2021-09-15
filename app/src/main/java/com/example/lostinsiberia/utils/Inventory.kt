package com.example.lostinsiberia.utils

import java.util.*
import kotlin.collections.HashMap

class Inventory {
    private val inventoryMaterial = HashMap<Material, Int>()
    private val inventoryCrafts = ArrayList<Craft>()

    fun getIM(): HashMap<Material, Int> {
        return inventoryMaterial
    }

    fun getIC(): ArrayList<Craft> {
        return inventoryCrafts
    }


    fun add(e : Any, q : Int? = null){
        if(e is Material && q != null){
            inventoryMaterial[e] = q
        }
        else if (e is Craft && q == null){
            inventoryCrafts.add(e)
        }
        else{
            throw error("Inventory error")
        }
    }

    fun remove(e : Material, q : Int = 1){
        if(e is Material){
            inventoryMaterial[e]?.minus(q)
        }
        else{
            throw error("Inventory error")
        }
    }
}
