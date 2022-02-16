package com.lookandhate.homework1.Task2

import com.lookandhate.homework1.auth
import com.lookandhate.homework1.updateCache

class Login(private val user: User) : Action() {
    override fun doAction() {
        println("")
        auth(::updateCache, user)
    }
}