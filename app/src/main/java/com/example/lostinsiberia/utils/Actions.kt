package com.example.lostinsiberia.utils


class Actions {
    val actionManager = ArrayList<Action>()

    fun add(e : Action){
        actionManager.add(e)
    }

    fun remove(e : Action){
        for (action in actionManager){
            if(action == e){
                actionManager.remove(action)
            }
        }
    }
}