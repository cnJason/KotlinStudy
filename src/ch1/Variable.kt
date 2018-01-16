package ch1


fun main(args: Array<String>) {

    val a: Int = 1 // 立即赋值.
    val b = 2 // 自动推断出 `Int`类型
    val c: Int // 如果没有初始值的话类型不能省略
    c = 3

    println("a= $a ,b = $b ,c= $c")

    var x = 5 // 自动推断出int类型.

    x += 1

    println("x = $x")
}