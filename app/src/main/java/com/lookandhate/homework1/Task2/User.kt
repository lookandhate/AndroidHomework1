package com.lookandhate.homework1.Task2

import java.util.Date

class User(var id: Int, var name: String, var age: Int, var type: Type) {
    val startTime: String by lazy { Date().toString() }

}