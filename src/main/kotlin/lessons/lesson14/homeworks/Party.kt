package lessons.lesson14.homeworks

class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Вечеринка состоится в $location. Вот столько будет участников: $attendees.")

    }
}
fun main() {
    val party = Party("моем доме", 10)
    party.details()
}