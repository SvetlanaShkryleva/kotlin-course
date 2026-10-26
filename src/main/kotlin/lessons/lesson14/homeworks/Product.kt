package lessons.lesson14.homeworks

data class Product(val name: String, val price: Double, val quantity: Int)
fun main() {
    val product = Product("Кофе", 350.0, 1)
    println(product)
}