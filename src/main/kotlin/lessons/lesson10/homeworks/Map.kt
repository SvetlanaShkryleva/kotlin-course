package lessons.lesson10.homeworks


//Задачи на работу со словарём

//Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val emptyMap: Map<Int, Int> = mapOf<Int, Int>()
//Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val floatDoubleMap: Map<Float, Double> = mapOf(2.71828f to 101.0101, 1.1f to 202.0202)
//Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
val mutableMap: MutableMap<Int, String> = mutableMapOf<Int, String>()
fun main () {
    //Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    mutableMap[1] = "Один"
    mutableMap[2] = "Два"
    //Используя словарь из предыдущего задания, извлеките значение, используя ключ.
    val exists = mutableMap[1]
    //Попробуй получить значение с ключом, которого в словаре нет.
    val notExists = mutableMap[3]
    //Удалите определенный элемент из изменяемого словаря по его ключу.
    mutableMap.remove(1)
    //Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val doubleIntMap: Map<Double, Int> = mapOf(1.1 to 1, 2.2 to 2, 3.4 to 3)
    for ((dividend, divisor) in doubleIntMap) {
        if (divisor == 0) {
            println("бесконечность")
        } else {
            println(dividend / divisor)
        }
    }
    //Измените значение для существующего ключа в изменяемом словаре.
    //Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val firstMap: Map<Int, String> = mapOf(1 to "a", 2 to "b")
    val secondMap: Map<Int, String> = mapOf(3 to "c", 4 to "d")
    val thirdMap: MutableMap<Int, String> = mutableMapOf<Int, String>()
    for ((key, value) in firstMap) {
        thirdMap[key] = value
    }
    for ((key, value) in secondMap) {
        thirdMap[key] = value
    }
    //Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val sMap: Map<String, List<Int>> = mapOf("q" to listOf(4, 6, 234, -23234, 5), "dfs" to listOf(4, 6, 234, -23234, 5))
    //Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    //Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
}

//Задачи на подбор оптимального типа для словаря

//Словарь библиотека: Ключи - автор книги, значения - список книг
val libraryMap: Map<String, List<String>> = mapOf<String, List<String>>()
//Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
val plantMap: Map<String, List<String>> = mapOf<String, List<String>>()
//Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
val sportMap: Map<String, List<String>> = mapOf<String, List<String>>()
//Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
val medMap: Map<String, List<String>> = mapOf<String, List<String>>()
//Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
val travelMap: Map<String, Map<String, List<String>>> = mapOf<String, Map<String, List<String>>>()
