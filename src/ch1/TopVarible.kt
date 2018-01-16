package ch1

val PI = 3.14
var x = 0

fun incrementX() {
    x += 1
}

fun main(args: Array<String>) {
    println("x = $x; PI = $PI")
    incrementX()
    println("incrementX()")
    println("x = $x; PI = $PI")
}