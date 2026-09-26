package lessons.lesson07.homeworks

fun main () {
    //Задания для цикла for
    //Прямой диапазон
    //Напишите цикл for, который выводит числа от 1 до 5.
    for (num in 1..5) {
        print(num)
        print(' ')
    }
    println()
    //Напишите цикл for, который выводит четные числа от 1 до 10.
    for (num in 2..10 step 2){
        print(num)
        print(' ')
    }
    println()
    //Обратный диапазон
    //Создайте цикл for, который выводит числа от 5 до 1.
    for (num in 5 downTo 1) {
        print(num)
        print(' ')
    }
    println()
    //Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (num in 10 downTo 1 step 2) {
        print(num)
        print(' ')
    }
    println()
    //С шагом (step)
    //Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (num in 1..9 step 2) {
        print(num)
        print(' ')
    }
    println()
    //Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (num in 3..20 step 3) {
        print(num)
        print(' ')
    }
    println()
    //Использование до (until)
    //Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    var size: Int = 11
    for (num in 3 until size step 2) {
        print(num)
        print(' ')
    }
    println()
    //Задания для цикла while
    //Цикл while
    //Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var num = 1
    while (num < 6) {
        print(num * num)
        num += 1
        print(' ')
    }
    println()
    //Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var ten: Int = 10
    while(ten != 5) {
        ten -= 1
    }
    print(ten)
    println()
    //Цикл do while
    //Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var five: Int = 5
    do {
        print(five)
        print(' ')
        five -= 1
    } while (five > 0)
    println()
    //Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var counter: Int = 5
    do {
        print(counter)
        print(' ')
        counter += 1
    } while (counter < 10)
    println()
    //Задания для прерывания и пропуска итерации
    //Использование break
    //Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
        print(i)
        print(' ')
    }
    println()
    //Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var one: Int = 1
    while (true) {
        if (one == 10) break
        print(one)
        print(' ')
        one += 1
    }
    println()
    //Использование continue
    //В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (n in 1..10) {
        if (n % 2 == 0) continue
        print(n)
        print(' ')
    }
    println()
    //Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var n: Int = 0
    while (n < 10) {
        n += 1
        if (n % 3 == 0) continue
        print(n)
        print(' ')
    }
    println()
}
