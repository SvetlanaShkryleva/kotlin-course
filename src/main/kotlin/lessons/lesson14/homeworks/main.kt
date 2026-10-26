package lessons.lesson14.homeworks

private fun check(description: String, expected: Any?, actual: Any?) {
    val mark = if (expected == actual) "OK  " else "FAIL"
    println("[$mark] $description")
    println("        ожидалось: $expected")
    println("        получено:  $actual")
}

fun main() {
    println("========== СЦЕНАРИЙ 1: базовые операции ==========\n")

    val rack = Rack(maxShelves = 3)
    val shelf1 = Shelf(capacity = 20)
    val shelf2 = Shelf(capacity = 15)
    val shelf3 = Shelf(capacity = 10)
    val shelf4 = Shelf(capacity = 5)   // 4-я полка — не должна влезть в лимит

    println("--- addShelf ---")
    check("addShelf(shelf1), стеллаж пуст",             true,  rack.addShelf(shelf1))
    check("addShelf(shelf2)",                            true,  rack.addShelf(shelf2))
    check("addShelf(shelf3)",                            true,  rack.addShelf(shelf3))
    check("addShelf(shelf4) — превышает maxShelves=3",   false, rack.addShelf(shelf4))
    check("addShelf(shelf1) повторно — уже стоит",       false, rack.addShelf(shelf1))
    check("getShelves().size",                           3,     rack.getShelves().size)

    println("\n--- addItem: как предметы разложатся по полкам ---")
    // План (считаем вручную, что должно произойти):
    //   полка 0 (20): книга(5) + журнал(6) + тетрадь(7) = 18, свободно 2
    //   полка 1 (15): ручка(5) + вилка(5)   + нож(3)    = 13, свободно 2
    //   полка 2 (10): стол(4)  + стул(4)                =  8, свободно 2
    //   лампа(5) не влезает ни на одну — вернётся false
    val addPlan = listOf(
        "книга"   to true,   // полка 0
        "журнал"  to true,   // полка 0
        "тетрадь" to true,   // полка 0 (стало 18/20)
        "ручка"   to true,   // полка 0 полна → полка 1
        "вилка"   to true,   // полка 1
        "нож"     to true,   // полка 1 (стало 13/15)
        "стол"    to true,   // полка 1 полна → полка 2
        "стул"    to true,   // полка 2 (стало 8/10)
        "лампа"   to false   // ни одна не вмещает
    )
    for ((name, expected) in addPlan) {
        check("addItem(\"$name\")", expected, rack.addItem(name))
    }

    println("\n--- containsItem ---")
    check("containsItem(\"вилка\")", true,  rack.containsItem("вилка"))
    check("containsItem(\"лампа\")", false, rack.containsItem("лампа"))
    check("containsItem(\"шкаф\")",  false, rack.containsItem("шкаф"))

    println("\n--- printContents ---")
    println("Ожидаемое содержимое:")
    println("  полка 0: capacity=20, available=2, [книга, журнал, тетрадь]")
    println("  полка 1: capacity=15, available=2, [ручка, вилка, нож]")
    println("  полка 2: capacity=10, available=2, [стол, стул]")
    println("\nРеальный вывод printContents():")
    rack.printContents()

    println("--- removeItem ---")
    check("removeItem(\"вилка\") — есть на полке 1", true,  rack.removeItem("вилка"))
    check("removeItem(\"вилка\") повторно — уже нет", false, rack.removeItem("вилка"))
    check("containsItem(\"вилка\") после удаления",  false, rack.containsItem("вилка"))
    // После удаления вилки: полка 1 = [ручка, нож]

    println("\n--- removeShelf ---")
    check("removeShelf(1) — вернёт предметы удалённой полки",
        listOf("ручка", "нож"), rack.removeShelf(1))
    check("getShelves().size после удаления", 2, rack.getShelves().size)
    check("removeShelf(99) — нет такой полки",
        emptyList<String>(), rack.removeShelf(99))

    println("\n========== СЦЕНАРИЙ 2: advancedRemoveShelf ==========\n")

    val r2 = Rack(maxShelves = 3)
    val a1 = Shelf(20)
    val a2 = Shelf(10)
    val a3 = Shelf(5)
    r2.addShelf(a1); r2.addShelf(a2); r2.addShelf(a3)

    // Хитрый набор: если раскладывать в порядке добавления — застрянет,
    // если раскладывать начиная с самых длинных — всё поместится.
    a1.addItem("ручка")     // 5
    a1.addItem("карандаш")  // 8
    // a1 = [ручка(5), карандаш(8)], использовано 13 из 20

    println("До удаления полки 0:")
    println("  полка 0 (20): ${a1.getItems()}")  // [ручка, карандаш]
    println("  полка 1 (10): ${a2.getItems()}")  // []
    println("  полка 2 (5):  ${a3.getItems()}")  // []

    println("\nОжидание (сортировка по убыванию длины):")
    println("  карандаш(8) → полка 1 (10): 8 <= 10, ok")
    println("  ручка(5)    → полка 1 (10): 8+5=13 > 10 → полка 2 (5): 5 <= 5, ok")
    println("  unplaced = []")
    println("  Без сортировки ручка(5) заняла бы полку 1,")
    println("  и карандаш(8) не влез бы никуда.\n")

    val unplaced = r2.advancedRemoveShelf(0)
    check("advancedRemoveShelf(0) — все предметы разложены",
        emptyList<String>(), unplaced)
    check("getShelves().size", 2, r2.getShelves().size)
    check("полка 0 (бывшая a2) содержит",
        listOf("карандаш"), r2.getShelves()[0].getItems())
    check("полка 1 (бывшая a3) содержит",
        listOf("ручка"), r2.getShelves()[1].getItems())

    println("\nРеальный printContents() после перераспределения:")
    r2.printContents()

    println("--- advancedRemoveShelf с невалидным индексом ---")
    check("advancedRemoveShelf(99)", emptyList<String>(), r2.advancedRemoveShelf(99))
}