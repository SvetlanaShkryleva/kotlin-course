package lessons.lesson09.homeworks

fun main () {
//  Работа с массивами Array
//  1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
//  2. Создайте пустой массив строк размером 10 элементов.
    val emptyArray: Array<String> = Array (10) {""}
//  3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val doubles: Array<Double> = Array(5){0.0}
    for (index in doubles.indices) {
        doubles[index] = index * 2.0
    }
//  4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val numbersInt: Array<Int> = Array (5){0}
    for (index in numbersInt.indices) {
      numbersInt[index] = index * 3
    }
//  5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val notAllNullArray = arrayOfNulls<String>(3)
    notAllNullArray[1] = ""
    notAllNullArray[2] = ""
//  6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val a1: Array<Int> = arrayOf(1, 2, 3)
    val a1_copy: Array<Int> = Array(a1.size){0}
    for (index in a1.indices) {
        a1_copy[index] = a1[index]
    }
//  7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val a2: Array<Int> = arrayOf(1, 2, 3)
    val a3: Array<Int> = Array(a1.size){1}
    val a4: Array<Int> = Array(a1.size){0}
    for (index in a2.indices) {
        a4[index] = a2[index] + a3[index]
    }
    println(a2)
    println(a3)
    println(a4)
//  8. Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val a5: Array<Int> = arrayOf(1, 2, 3, 5, 8, 9, 10)
    var answer: Int = 0
    var index: Int = 0
    var flag: Boolean = false
    while(index < a5.size) {
        if (a5[index] == 5) {
            flag = true
            answer = index
            println(answer)
            break
        }
        index += 1
    }
    if (flag == false) {
        println(-1)
    }
//  9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val a6: Array<Int> = arrayOf(3, 6, 4, 2, 21, 25, 0, 23, 43)
    for (elem in a6) {
        print(elem)
        if (elem % 2 == 0) {
            print(" четное")
        } else {
            print(" нечетное")
        }
        println()
    }
//  10. Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    fun search(array: Array<String>, str: String) {
        if (array.contains(str)) {
        println(str)
        } else {
            println("Not found")
        }
    }

//  Работа со списками List
//  Создайте пустой неизменяемый список целых чисел.
    val readOnlyList: List<Int> = emptyList()
//  Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val readOnlyListString: List<String> = listOf("Hello", "World", "Kotlin")
//  Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
//  Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    mutableList.add(6)
    mutableList.add(7)
    mutableList.add(8)
    println(mutableList)
//  Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val notReadOnlyListString: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    notReadOnlyListString.remove("World")
//  Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    for (element in mutableList) {
        print(element)
        print(", ")
    }
    println()
//  Создайте список строк и получите из него второй элемент, используя его индекс.
    val firstList: List<String> = listOf("z", "w", "d", "j")
    val secondList: MutableList<String> = mutableListOf()
    for (element in firstList) {
        secondList.add(element)
    }
    print(secondList)
    println()
//  Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    println(mutableList)
    mutableList[2] = 111
    println(mutableList)
//  Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val list1: MutableList<String> = mutableListOf("a", "b", "c")
    val list2: List<String> = listOf("d", "e", "f", "g")
    for (element in list2) {
        list1.add(element)
    }
    println(list1)
//  Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
//    val intList: List<Int> = listOf(4, 6, 234, -23234, 5)
//    var maxElem: Int =
//    var minElem: Int =
//    for (elem in intList) {
//
//
//    }
//  Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
//
//  Работа с Множествами Set
//  Создайте пустое неизменяемое множество целых чисел.
    val emptySet: Set<Int> = emptySet()
//  Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val intSet: Set<Int> = setOf(1, 2, 3)
//  Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val mutableSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
//  Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    mutableSet.add("Swift")
    mutableSet.add("Go")
//  Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val intMutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
    intMutableSet.remove(2)
//  Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    for (element in intSet) {
        print(element)
        print(", ")
    }
    println()
//  Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.
    fun search2(mySet: Set<String>, str: String) {
        var finalAnswer: Boolean = false
        for (element in mySet){
            if ( element == str) {
                finalAnswer = true
                break
            }
        }
    println(finalAnswer)
    }
//  Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.

}
