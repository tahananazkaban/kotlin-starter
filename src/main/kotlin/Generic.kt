interface List<T>{
    operator fun get(index: Int): T
}

class LongList : List<Long>{
    override fun get(index: Int): Long {
        return this[index]
    }
}

class ArrayList<T>: List<T>{
    override fun get(index: Int): T {
        return this[index]
    }
}

// Generic function
//public fun <T> List<T>.slice(indices: Iterable<Int>): List<T> {
//    /*...*/
//}

// Constraint type parameter
class ListNumber<T : Number> : List<T>{
    override fun get(index: Int) : T{
        return this[index]
    }
}

//fun <T : Number> List<T>.sumNumber() : T {
//    /* .. */
//}


// Variance
abstract class Vehicle(wheel: Int)

//class Car(speed: Int) : Vehicle(4)
class Car2(speed: Int) : Vehicle(4)
class MotorCycle(speed: Int) : Vehicle(2)

// Covariant (keyword: out)
//interface List<out E> : Collection<E> {
//    operator  fun get (index: Int) : E
//}

// Contravariant (keyo
//interface Comparable<in T> {
//    operator fun compareTo(other: T) : Int
//}

fun main () {
    val longArrayList = ArrayList<Long>()
//    val firstLong = longArrayList.get(1)
//    println(firstLong)
    val n1 = ListNumber<Long>()
    val n2 = ListNumber<Int>()
    val numbers = (1..100).toList()
    print(numbers.slice<Int>(1..10))

//    val x1 = listOf(1, 2, 3, 4, 5)
//    x1.sumNumber()
    val car = Car2(200)
    val motorCycle = MotorCycle(100)
    var vehicle: Vehicle = car
    vehicle = motorCycle
    println("\nVehicle $vehicle")
    println("Car: $car")
    println("Motor: $motorCycle")

    println()

    val carList1 = listOf(Car2(100), Car2(120))
    val vehicleList = carList1
    println("Vehicle list: $vehicleList")
}
