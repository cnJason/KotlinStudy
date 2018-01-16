package ch1

fun maxOf2(a: Int, b: Int) = if (a > b) a else b


fun main(args: Array<String>) {
    println("max of 0 and 42 is ${maxOf2(0,42)}")
}