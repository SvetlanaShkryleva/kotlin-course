package lessons.lesson14.homeworks

object Moon {
    val isVisible: Boolean = true
    val phase: String = "полнолуние"

    fun showPhase() {
        if (isVisible) {
            println("Луна видна в фазе $phase.")
        } else {
            println("Луны не видно.")
        }
    }
}
fun main() {
    Moon.showPhase()
}