package ch1

fun main(args: Array<String>) {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")

    fruits.filter { it.startsWith("a") }.sortedBy { it }.map { it.toUpperCase() }.forEach { println(it) }
}