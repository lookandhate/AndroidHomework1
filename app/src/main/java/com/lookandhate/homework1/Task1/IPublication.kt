package com.lookandhate.homework1.Task1

interface IPublication {
    val wordCount: Int
    val price: Double

    fun getType(): String
    fun publicationInfo(): String
}