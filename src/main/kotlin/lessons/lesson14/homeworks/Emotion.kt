package lessons.lesson14.homeworks

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        println("Эмоция $type с интенсивностью $intensity.")
    }
}
fun main() {
    val emotion = Emotion("тоска", 2)
    emotion.express()
}