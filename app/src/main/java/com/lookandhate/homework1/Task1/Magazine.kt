package com.lookandhate.homework1.Task1

class Magazine(override val wordCount: Int, override val price: Double) : IPublication {
    override fun getType(): String {
        return "Magazine"
    }

    override fun publicationInfo(): String {
        return "Word count is ${wordCount}. Price is $price €"
    }
}