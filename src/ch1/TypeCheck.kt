package ch1

fun getStringLenth(obj: Any): Int? {
    if (obj is String) {
        // 'obj'在该条件分支内自动转换成'String'
        return obj.length
    }
    return null
}


fun main(args: Array<String>) {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLenth(obj) ?: "... error, not a String"}")
    }

    printLength("InComprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}