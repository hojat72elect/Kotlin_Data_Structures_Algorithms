fun main() {
    val box = Box<Int>(2)

}

class Box<T>(t: T) {
    var value = t
}