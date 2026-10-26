package lessons.lesson14.homeworks

class Concert(val band: String, val location: String, val cost: Int, val capacity: Int) {

    private var ticketSold = 0

    fun buyTicket() {
        if (ticketSold < capacity) {
            ticketSold++
        }
    }

    fun printInfo() {
        println("Концерт группы $band в городе $location. Стоимость билета $cost руб. Осталось ${capacity - ticketSold} мест")
    }
}
fun main() {
    val concert = Concert("Мельница", "Москва", 2000, 5000)
    concert.printInfo()
    concert.buyTicket()
    println("Купили 1 билет. Успевайте купить!")
    concert.printInfo()
}