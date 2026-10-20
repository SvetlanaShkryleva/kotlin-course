package lessons.lesson13.homeworks

import lessons.lesson10.homeworks.mutableMap

fun main() {

//1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val testTime = mapOf("Первый" to 2, "Второй" to 46)
    val result = testTime
        .values
        .average()
    println(result)

//2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов, а значения — строка с метаданными. Выведите список всех тестовых методов.
    println(testTime.keys)

//3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val mM = mutableMapOf("Первый" to 2, "Второй" to 46)
    mM["Третий"] = 50
    println(mM)

//4. Посчитайте количество успешных тестов в словаре с результатами (ключ — название, значение — результат из `passed`, `failed`, `skipped`).
    val testResults = mapOf("Первый" to "passed", "Второй" to "failed", "Третий" to "skipped")
    val successTests = testResults.filter { it.value == "passed"}
    println(successTests)

//5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ — название, значение — статус исправления).
    val mMBTS = mutableMapOf("Первый" to "Исправлен", "Второй" to "Исправлен", "Третий" to "Создан")
    mMBTS.entries.removeAll { it.value == "Исправлен" }
    println(mMBTS)

//6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа) выведите сообщение о странице и статусе её проверки.
    val webPages = mapOf("www" to 200, "http" to 500)
    for ((key, value) in webPages) {
        println("URL: $key, Status: $value")
    }

//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val responseTime = mapOf("1" to 10, "2" to 5, "3" to 9)
    val badResponseTime = responseTime.filterValues { it > 5 }
    println(badResponseTime)

//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа; если endpoint отсутствует, предположите, что он не был протестирован.
    val resultAPI = mutableMapOf("Первый" to "Успех", "Второй" to "Фейл", "Третий" to "Фейл")
    println(resultAPI.getOrElse("Первый") { "Не был протестирован" })

//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение — сама конфигурация),
// получите значение для `"browserType"`. Ответ не может быть `null`.
    val configValues = mutableMapOf("browserType" to "Chrome", "OSType" to "Windows")
    println(configValues.getValue("browserType"))

//10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val versions = mapOf("Первый" to "1.0.0", "Второй" to "1.0.5")
    val versions2 = versions + ("Третий" to "3.5")
    println(versions2)

//11. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение — строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val mobile = mutableMapOf("Устройство 1" to "Настройка 1", "Устройство 2" to "Настройка 1 и настройка 2", "Устройство 3" to "Настройки по умолчанию")
    println(mobile.getOrElse("Устройство 4") { "Настройки по умолчанию" })

//12. Проверьте, содержит ли словарь с ошибками тестирования (ключ — код ошибки, значение — описание ошибки) определённый код ошибки.
    val errors = mapOf(404 to "Not Found", 500 to "Internal Server Error", 403 to "Forbidden")
    println(errors.containsKey(500))

//13. Отфильтровать сценарии по версии в ключе ("TestID_Version").
    val scenarios = mapOf("login_1.0"   to "Passed", "logout_1.0"  to "Failed", "payment_2.0" to "Passed", "search_1.0"  to "Skipped")
    val forVersion = scenarios.filterKeys { it.substringAfterLast('_') == "1.0" }
    println(forVersion)

//14. Есть ли модули с неудачным тестированием.
    val modules2 = mapOf("Auth" to "Passed", "Payment" to "Failed", "Search" to "Passed")
    println(modules2.any { it.value == "Failed" })

//15. Добавить в изменяемый словарь настройки из другого словаря.
    val envSettings = mutableMapOf("browser" to "Chrome", "os" to "Windows")
    val extraSettings = mapOf("timeout" to "30s", "retries" to "2")
    envSettings.putAll(extraSettings)
    println(envSettings)

//16. Объединить два неизменяемых словаря с данными о багах.
    val bugsA = mapOf("bug1" to "open", "bug2" to "fixed")
    val bugsB = mapOf("bug3" to "open", "bug4" to "in progress")
    val allBugs = bugsA + bugsB
    println(allBugs)

//17. Очистить изменяемый словарь с временными данными.
    val lastRun = mutableMapOf("test1" to "ok", "test2" to "fail")
    lastRun.clear()
    println(lastRun)

//18. Исключить из отчёта пропущенные тесты.
    val report = mapOf("t1" to "passed", "t2" to "skipped", "t3" to "failed", "t4" to "skipped")
    val withoutSkipped = report.filterValues { it != "skipped" }
    println(withoutSkipped)

//19. Копия словаря конфигураций без нескольких конфигураций.
    val configs = mapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4)
    val toRemove = setOf("b", "d")
    val trimmed = configs.filterKeys { it !in toRemove }
    println(trimmed)

//20. Отчёт в виде списка строк "Test ID: результат".
    val testOutcomes = mapOf("T-01" to "Passed", "T-02" to "Failed", "T-03" to "Skipped")
    val lines = testOutcomes.map { (id, res) -> "Test ID: $id — $res" }
    println(lines)

//21. Изменяемый словарь → неизменяемый (для архивации).
    val mutableResults = mutableMapOf("t1" to "passed", "t2" to "failed")
    val archived: Map<String, String> = mutableResults.toMap()
    println(archived)

//22. Заменить числовые ID тестов на строковые.
    val numericIds = mapOf(101 to 2.5, 202 to 3.1, 303 to 1.8)
    val stringIds = numericIds.mapKeys { it.key.toString() }
    println(stringIds)

//23. Увеличить каждую оценку производительности на 10%.
    val perf = mapOf("1.0.0" to 120.0, "1.1.0" to 98.5, "1.2.0" to 150.0)
    val boosted = perf.mapValues { it.value * 1.1 }
    println(boosted)

//24. Пуст ли словарь с ошибками компиляции.
    val compileErrors = mapOf<String, String>()
    println(compileErrors.isEmpty())

//25. Словарь с нагрузочным тестированием не пуст.
    val loadResults = mapOf("rps" to 1200, "latency" to 85)
    println(loadResults.isNotEmpty())

//26. Все ли автотесты прошли успешно.
    val allResults = mapOf("t1" to "passed", "t2" to "passed", "t3" to "passed")
    println(allResults.all { it.value == "passed" })

//27. Есть ли хотя бы один тест с ошибкой.
    val someResults = mapOf("t1" to "passed", "t2" to "failed")
    println(someResults.any { it.value == "failed" })   // true

//28. Тесты, которые упали И содержат "optional" в названии.
    val serviceResults = mapOf(
        "login_optional"   to "failed",
        "login_required"   to "failed",
        "search_optional"  to "passed",
        "payment_optional" to "failed"
    )
    val failedOptional = serviceResults.filter { (name, status) ->
        status != "passed" && "optional" in name
    }
    println(failedOptional)
}