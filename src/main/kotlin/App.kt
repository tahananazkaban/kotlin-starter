import kotlin.reflect.KProperty
import kotlin.random.Random
import kotlin.math.*
//import kotlin.math.PI
//import kotlin.math.cos as cosinus
//import kotlin.math.sqrt as akar

// Delegate Property
class DelegateName{
    private var value: String = "Default"
    operator fun getValue(classRef: Any?, property: KProperty<*>) : String {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }
    operator fun setValue(classRef: Any?, property: KProperty<*>, newValue: String){
        println("Fungsi ini sama seperti setter untuk properti ${property.name} pada class $classRef")
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class DelegateGenericClass{
    private var value: Any = "Default"
    operator fun getValue(classRef: Any, property: KProperty<*>) : Any {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }
    operator fun setValue(classRef: Any, property: KProperty<*>, newValue: Any){
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class Bicycle{
    var name: String by DelegateName()
}

class Motorcycle{
    var name: String by DelegateName()
}

class Car{
    var name: String by DelegateName()
}

class Animal (val name: String,
              val weight: Double,
              val age: Int,
              val isMammal: Boolean){
    fun eat(){
        println("$name, lets go eat!")
    }
    fun sleep(){
        println("$name, its time to sleep")
    }
}

class AnimalDelegate{
    var name: Any by DelegateGenericClass()
    var weight: Any by DelegateGenericClass()
    var age: Any by DelegateGenericClass()
}

// Access Modifiers
class PrivateAnimal (
    private var name: String,
    private val weight: Double,
    private val age: Int,
    private val isMammal: Boolean){

    fun getName() : String{
        return name;
    }

    fun setName(newName: String){
        name = newName
    }
}

// Protected modifiers
open class ProtectedAnimal (
    val name: String,
    protected val weight: Double)

class Horse (
    hName: String, hWeight: Double) : ProtectedAnimal(hName, hWeight)

// Internal
internal class InternalAnimal (val name: String)

// Parent class
open class ParentAnimal(
    val name: String,
    val weight: Double,
    val age: Int,
    val isCarnivore: Boolean) {

    open fun eat(){
        println("$name, lets go eat!")
    }

    open fun sleep(){
        println("$name, time to sleep!")
    }
}

// Child class of ParentAnimal
class Cat(
    cName: String,
    cWeight: Double,
    cAge: Int,
    cIsCarnivore: Boolean,
    val furColor: String,
    val numberOfFeet: Int)
    : ParentAnimal(cName, cWeight, cAge, cIsCarnivore) {

    fun playWithHuman(){
        println("$name, lets go play outside!")
    }

    override fun eat(){
        println("$name is still eat fish!")
    }

    override fun sleep(){
        println("$name is sleeping in sofa")
    }
}

class Biawak(){
    var name: String = "Hunabah"
        get(){
            println("This is getter")
            return field
        }
        set(value){
            println("This is setter")
            field = value
        }
}

// Extension properties
class FootballCLub(var name: String, var country: String, var since: Int, var isChampion: Boolean)
val FootballCLub.getFootballClubInfo : String
    get() = "FC Name: ${this.name} in ${this.country} since ${this.since}. Has a champion league = ${isChampion}"

class Person(name: String, weight: Double, age: Int){
    val name: String
    val weight: Double
    val age: Int
    var isHaveReligion: Boolean

    // Primary constructor
    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0 else age
        this.name = name
        this.isHaveReligion = false
    }
    // Secondary constructor
    constructor(name: String, weight: Double, age: Int, isHaveReligion: Boolean) : this(name, weight, age) {
        this.isHaveReligion = isHaveReligion
    }
}

class DefaultPerson{
    val name: String = "John Pilgrim"
    val weight: Double = 70.5
    val age: Int = 17
    var isHaveReligion: Boolean = true
}

// Overloading
class Calculator {
    fun add(value1: Int, value2: Int) = value1 + value2
    fun add(value1: Int, value2: Int, value3: Int) = value1 + value2 + value3
    fun add(value1: Double, value2: Double) = value1 + value2
    fun add(value1: Float, value2: Float) = value1 + value2

    fun min(value1: Int, value2: Int) = if (value1 < value2) value1 else value2
    fun min(value1: Double, value2: Double) = if (value1 < value2) value1 else value2
}

// Abstract
abstract class AbstractAnimal (val name: String,
              val weight: Double,
              val age: Int,
              val isMammal: Boolean){
    fun eat(){
        println("$name, lets go eat!")
    }
    fun sleep(){
        println("$name, its time to sleep")
    }
}

// Interface
interface IFly {
    fun fly()
    val numOfWings: Int
}

class Bird(override val numOfWings: Int) : IFly {
    override fun fly(){
        if (numOfWings > 0) println("I fly with $numOfWings wings")
        else println("I flying without wings")
    }
}

fun main(){
    println("Test")
    val someString = "This is Kuple!"
    println(someString.reversed())
    println(someString.toUpperCase())
    println(someString.toLowerCase())

    val cat1 = Animal("Kuple", 4.2, 2, true)
    println("Name: ${cat1.name} and the weight is ${cat1.weight}. ${cat1.name} is ${cat1.age} yo. They are ${cat1.isMammal}")
    cat1.eat()
    cat1.sleep()

    val biawak1 = Biawak()
    println(biawak1.name)

    biawak1.name = "Kiopa"
    println(biawak1.name)

    println()
    println()

    var bicycle1 = Bicycle()
    bicycle1.name = "BMX Wimcycle"

    var motorcycle1 = Motorcycle()
    motorcycle1.name = "Honda C70"

    var car1 = Car()
    car1.name = "BMW E30"

    println("Bicycle name: ${bicycle1.name}")
    println("Motorcycle name: ${motorcycle1.name}")
    println("Car name: ${car1.name}")

    println()
    println()

    val animal2 = AnimalDelegate()
    animal2.name = "Bukare"
    animal2.weight = 6.2
    animal2.age = 1
//
//    val animal3 = AnimalDelegate()
//    animal3.name = "Hiyosi"

    println("Animal2 name = ${animal2.name}")
    println("Animal2 weight = ${animal2.weight}")
    println("Animal 2 age = ${animal2.age}")


    // Extension properties
    println()
    println()
    val mancityFC = FootballCLub("Manchester City", "London", 1981, true)
    println(mancityFC.getFootballClubInfo)

    // Primary constructor
    val person1 = Person("Hublanafia M.", 52.3, 21, true)
    println("Name of person1 = ${person1.name} ${person1.age} years old. Weight is = ${person1.weight} " +
            "and considered to a religion = ${person1.isHaveReligion}")

    // Secondary constructor
    val person2 = Person("Denny Polpora", 65.2, 28)
    println("Name of person2 = ${person2.name} ${person2.age} years old. Weight is = ${person2.weight} " +
            "and considered to a religion = ${person2.isHaveReligion}")

    val defaultPerson = DefaultPerson()
    println("Name of default person = ${defaultPerson.name} ${defaultPerson.age} years old. Weight is = ${defaultPerson.weight} " +
            "and considered to a religion = ${defaultPerson.isHaveReligion}")

    println()

    // Access modifiers
    val privateCat = PrivateAnimal("Puspa", 2.5, 2, false)
    println(privateCat.getName())
    privateCat.setName("Cemeng")
    println("From setter: ${privateCat.getName()}")

    println()

    val protectedHorse = Horse("Turinda", 202.9)
    println("Horse name: ${protectedHorse.name}")
//    println("Horse weight: ${protectedHorse.weight}") // Cannot acces weight (protected)

    println()

    val home1Cat = Cat ("Peta", 5.3, 1, true, "White", 4)
    println("${home1Cat.name}, ${home1Cat.age} years old")
    home1Cat.playWithHuman()
    home1Cat.eat()
    home1Cat.sleep()

    println()

    // Overloading
    val calc = Calculator()

    println(calc.add(2, 4))
    println(calc.add(2.5, 2.2))
    println(calc.add(6f, 7f))
    println(calc.add(1, 2, 3))

    println(calc.min(9, 2))
    println(calc.min(17.2, 18.3))

    println()

//    AbstractAnimal("Palka", 1.5, 1, true)

    // Interface
    val bird1 = Bird(4)
    bird1.fly()

    println()

    // Package
    val randomNum1 = Random(0).nextInt(1, 10)
    println("Random number: $randomNum1")
    println("Phi: $PI")
    println("Cos 120: ${cos(120.0)}")
    println("Sqrt 27: ${sqrt(27.0)}")







}