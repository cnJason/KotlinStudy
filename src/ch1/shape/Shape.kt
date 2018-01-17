package ch1.shape

fun main(args: Array<String>) {

}


/**
 * 形状类.
 */
abstract class Shape(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface Rectangleproperties {
    val isSquare: Boolean
}

