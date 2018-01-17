package ch1

fun main(args: Array<String>) {
    val x = 10
    val y = 9

    if (x in 1..y+1) {
        println("fits in range")
    }
}