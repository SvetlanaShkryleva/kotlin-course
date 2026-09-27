package lessons.lesson08.homeworks

fun main () {
    stringChange(myOriginalString)
    getLog(logString)
    hideNumbers(cardNumber)
    emailReplacer(email)
    fileName(path)
    phraseToAbbr(phrase)
}

//1. Преобразование строк

val myOriginalString = "Удача"
fun stringChange(originalString: String) {
    var newString: String = ""
    if (originalString.contains("невозможно", true)) {
        newString = originalString.replace("невозможно", "совершенно точно возможно, просто требует времени", true)
    }
    if (originalString.startsWith("Я не уверен")) {
        newString = originalString + ", но моя интуиция говорит об обратном"
    }
    if (originalString.contains("катастрофа", true)) {
        newString = originalString.replace("катастрофа", "интересное событие", true)
    }
    if (originalString.endsWith("без проблем")) {
        newString = originalString.replace("без проблем", "с парой интересных вызовов на пути")
    }
    if (originalString.split(" ").size == 1) {
        newString = "Иногда, " + originalString + ", но не всегда"
    }
    println(myOriginalString)
    println(newString)
}

//2. Извлечение даты из строки лога

val logString: String = "Пользователь вошел в систему -> 2021-12-01 09:48:23"
fun getLog (logString: String) {
    println(logString.split(" ")[(logString.split(" ").size - 2)])
    println(logString.split(" ")[(logString.split(" ").size - 1)])
}

//3. Маскирование личных данных

val cardNumber: String = "4539 1488 0343 6467"
fun hideNumbers(originalNumber: String) {
    var newNumbers = "**** **** **** " + originalNumber.substring(15)
    println(newNumbers)
}

//4. Форматирование адреса электронной почты.

val email: String = "username@example.com"
fun emailReplacer(originalEmail: String) {
    var newEmail = originalEmail.replace("@", " [at] ")
    newEmail = newEmail.replace(".", " [dot] ")
    println(newEmail)
}
//5. Извлечение имени файла из пути.

val path: String = "C:/Пользователи/Документы/report.txt"
fun fileName(originalPath: String) {
    var newPath = originalPath.reversed()
    newPath = newPath.replace("/", " ")
    var myList :List<String> = newPath.split(" ")

    println(myList[0].reversed())
}

//6. Создание аббревиатуры из фразы.

val phrase: String = "Котлин лучший язык программирования"
fun phraseToAbbr(originalPhrase: String) {
    var abbr: String = ""
    var newAbbr: String = ""
    var listAbbr: List<String> = originalPhrase.split(" ")
    for (i in 1..listAbbr.size) {
        newAbbr += listAbbr[i - 1].uppercase()[0]
    }
    println(newAbbr)
}