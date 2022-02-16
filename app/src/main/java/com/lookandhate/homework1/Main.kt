package com.lookandhate.homework1

import com.lookandhate.homework1.Task1.Book
import com.lookandhate.homework1.Task1.IPublication
import com.lookandhate.homework1.Task1.Magazine
import com.lookandhate.homework1.Task2.*
import java.lang.Exception

val authCallback = object : IAuthCallback {
    override fun authSuccess() {
        println("authSuccess invoked")
    }

    override fun authFailed() {
        println("authFailed invoked")
    }

}

fun buy(publication: IPublication) {
    println("The purchase is complete. The purchase amount was ${publication.price}")
}

fun User.isAbove18YearsOld() {
    if (this.age < 18)
        throw Exception("User age below 18")
    println("User age above or equal 18")
}

inline fun auth(updateCacheFun: (Boolean) -> Unit, user: User) {
    try {
        user.isAbove18YearsOld()
        updateCacheFun(true)
        authCallback.authSuccess()

    } catch (e: Exception) {
        updateCacheFun(false)
        authCallback.authFailed()
    }

}

fun updateCache(isCacheUpdated: Boolean): Unit {
    if (isCacheUpdated)
        println("Cache updated!")
    else
        println("Cache was not updated!")
}

fun main() {
    val firstBook = Book(1000, 2500.0)
    val secondBook = Book(1337, 999.99)
    val magazine = Magazine(100, 9.99)

    println(firstBook.publicationInfo())
    println(secondBook.publicationInfo())
    println(magazine.publicationInfo())

    firstBook == secondBook

    val sum = { a: Double, b: Double -> a + b }
    println("Sum of 1.5 and 3.5 equal to ${sum(1.5, 3.5)}")

    val nullableBook: Book? = null
    buy(firstBook)
    if (nullableBook != null) {
        buy(nullableBook)
    }
    /*
    *
    * Second part of task
    *
    */
    println("=============================\nTask 2 goes below\n=============================")

    val elonMusk = User(0, "elon musk", 50, Type.FULL)
    println(elonMusk.startTime)
    Thread.sleep(1000)
    println(elonMusk.startTime)

    val listOfUsers = mutableListOf<User>(elonMusk)
    listOfUsers.apply {
        add(User(1, "sergey brin", 48, Type.FULL))
        add(User(2, "larry page", 48, Type.DEMO))
        add(User(3, "tim cook", 61, Type.DEMO))
        add(User(4, "me", 17, Type.DEMO))
    }

    val listOfUsersWithFullAccess =
        listOfUsers.filter { it.type == Type.FULL }

    val listOfUsernames = mutableListOf<String>()
    listOfUsersWithFullAccess.forEach { listOfUsernames.add(it.name) }
    println("First username: ${listOfUsernames[0]}\nLast username: ${listOfUsernames[listOfUsernames.size - 1]}")

    Registration().doAction()
    Login(listOfUsersWithFullAccess.first()).doAction()
    Login(listOfUsers[4]).doAction()
    Logout().doAction()


}

