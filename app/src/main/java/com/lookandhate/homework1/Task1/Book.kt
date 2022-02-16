package com.lookandhate.homework1.Task1

class Book(override val wordCount: Int, override val price: Double) : IPublication {
    override fun getType(): String {
        if (wordCount in 1 until 1000)
            return "Flash Fiction"
        if (wordCount in 1000 until 7500)
            return "Short Story"
        return "Novel"

    }

    override fun publicationInfo(): String {
        return "Word count is ${wordCount}. Price is $price€"
    }

    override fun equals(other: Any?): Boolean {
        println("Equals by reference: ${this === other}")
        println("Equals by super class equals method: ${super.equals(other)}")
        return super.equals(other)
    }


}