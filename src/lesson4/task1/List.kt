@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var a = 0.0
    for (i in v.indices) {
        a += v[i] * v[i]
    }
    return sqrt(a)
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) return 0.0
    val a = list.sum()
    val k = list.size
    return a / k
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val t = mean(list)
    for (i in 0 until list.size) {
        list[i] -= t
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var sum = 0
    for (i in a.indices) {
        sum += a[i] * b[i]
    }
    return sum
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var sum = 0
    var squarX = 1
    for (element in p) {
        sum += element * squarX
        squarX *= x
    }
    return sum
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    for (i in 1 until list.size) {
        list[i] = list[i - 1] + list[i]
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var i = 2
    var nn = n
    val list = mutableListOf<Int>()
    while (nn > 1) {
        if (nn % i == 0) {
            nn /= i
            list.add(i)
        } else i++

    }
    return list
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    val t = factorize(n)
    return t.joinToString(
        separator = "*"
    )
}

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()


/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val listArab = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
    val listRoman = listOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
    var string = ""
    var nn = n
    while (nn > 0) {
        for (i in listArab.size - 1 downTo 0) {
            if (nn - listArab[i] >= 0) {
                string += listRoman[i]
                nn -= listArab[i]
                break
            }
        }
    }
    return string
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val unit = listOf(
        "один", "два", "три", "четыре", "пять",
        "шесть", "семь", "восемь", "девять"
    )
    val unit1 = listOf(
        "одна", "две", "три", "четыре", "пять",
        "шесть", "семь", "восемь", "девять"
    )
    val ten = listOf(
        "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
        "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    )
    val eleven = listOf(
        "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
        "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    )
    val hundred = listOf(
        "сто", "двести", "триста", "четыреста", "пятьсот",
        "шестьсот", "семьсот", "восемьсот", "девятьсот"
    )
    var string = ""
    if (n < 10) return unit[n - 1]
    if (n in 11..19) return eleven[n - 11]
    if (n in 10..90 && n % 10 == 0) return ten[n / 10 - 1]
    if (n in 11..99) {
        val q = n / 10 * 10
        string += ten[q / 10 - 1]
        string += " "
        string += unit[n % 10 - 1]
        return string
    }
    if (n in 100..999) {
        string += hundred[n / 100 - 1]
        if (n / 10 % 10 != 0) {
            val q = n / 10 % 10 * 10
            string += " "
            string += ten[q / 10 - 1]
        }
        if (n % 10 != 0) {
            string += " "
            string += unit[n % 10 - 1]
        }
        return string
    }
    if (n in 1000..9999) {
        if (n / 1000 == 1) string += "одна тысяча"
        if (n / 1000 == 2) string += "две тысячи"
        if (n / 1000 != 1) {
            if (n / 1000 in 3..4) {
                string += unit[n / 1000 - 1]
                string += " "
                string += "тысячи"
            }
            if (n / 100 in 5..9) {
                string += unit[n / 1000 - 1]
                string += " "
                string += "тысяч"
            }
        }
        if (n / 100 % 10 != 0) {
            val q = n / 100 % 10 * 100
            string += " "
            string += hundred[q / 100 - 1]
        }
        if (n / 10 % 10 != 0 && n / 10 % 10 * 10 !in 11..19) {
            val q = n / 10 % 10 * 10
            string += " "
            string += ten[q / 10 - 1]
        }
        if (n / 10 % 10 != 0 && n / 10 % 10 * 10 in 11..19) {
            val q = n / 10 % 10 * 10
            string += " "
            string += eleven[q - 11]
        }
        if (n % 10 != 0) {
            string += " "
            string += unit[n % 10 - 1]
        }
        return string
    }
    if (n in 10000..99999) {
        val q = n / 1000
        if (q in 11..19) {
            string += eleven[q - 11]
            string += " "
            string += "тысяч"
        }
        if (q in 10..90 && q % 10 == 0) {
            string += ten[q / 10 - 1]
            string += " "
            string += "тысяч"
        }
        if (q in 21..99 && q % 10 != 0) {
            val qqq = q / 10 * 10
            string += ten[qqq / 10 - 1]
            string += " "
            string += unit1[q % 10 - 1]
            string += " "
            if (q % 10 == 1) string += "тысяча"
            if (q % 10 in 2..4) string += "тысячи"
            if (q % 10 in 5..9) string += "тысяч"
        }
        if (n / 100 % 10 != 0) {
            if (n % 1000 in 100..999) {
                string += " "
                string += hundred[n % 1000 / 100 - 1]
                val t = n % 100
                if (t < 10 && t != 0) {
                    string += " "
                    string += unit[t - 1]
                }
                if (t in 11..19) {
                    string += " "
                    string += eleven[t - 11]
                }
                if (t in 10..90 && t % 10 == 0) {
                    string += " "
                    string += ten[t / 10 - 1]
                }
                if (t in 21..99 && t % 10 != 0) {
                    val q = t / 10 * 10
                    string += " "
                    string += ten[q / 10 - 1]
                    string += " "
                    string += unit[t % 10 - 1]
                }
            }
        }
        if (n / 100 % 10 == 0) {
            val t = n % 100
            if (t < 10 && t != 0) {
                string += " "
                string += unit[t - 1]
            }
            if (t in 11..19) {
                string += " "
                string += eleven[t - 11]
            }
            if (t in 10..90 && t % 10 == 0) {
                string += " "
                string += ten[t / 10 - 1]
            }
            if (t in 21..99 && t % 10 != 0) {
                val q = t / 10 * 10
                string += " "
                string += ten[q / 10 - 1]
                string += " "
                string += unit[t % 10 - 1]
            }
        }
        return string
    }
    if (n in 100000..999999) {
        string += hundred[n / 1000 / 100 - 1]
        if (n / 1000 % 10 == 0 && n / 10000 % 10 == 0) {
            string += " "
            string += "тысяч"
        }
        val t = n / 1000 % 100
        if (t < 10 && t != 0) {
            string += " "
            string += unit1[t - 1]
            if (t == 1) {
                string += " "
                string += "тысяча"
            }
            if (t in 2..4) {
                string += " "
                string += "тысячи"
            }
            if (t in 5..9) {
                string += " "
                string += "тысяч"
            }
        }
        if (t in 11..19) {
            string += " "
            string += eleven[t - 11]
            string += " "
            string += "тысяч"
        }
        if (t in 10..90 && t % 10 == 0) {
            string += " "
            string += ten[t / 10 - 1]
            string += " "
            string += "тысяч"
        }
        if (t in 21..99 && t % 10 != 0) {
            val q = t / 10 * 10
            string += " "
            string += ten[q / 10 - 1]
            string += " "
            string += unit1[t % 10 - 1]
            string += " "
            if (t % 10 == 1) string += "тысяча"
            if (t % 10 in 2..4) string += "тысячи"
            if (t % 10 in 5..9) string += "тысяч"
        }
        if (n / 100 % 10 != 0) {
            if (n % 1000 in 100..999) {
                string += " "
                string += hundred[n % 1000 / 100 - 1]
                val t = n % 100
                if (t < 10 && t != 0) {
                    string += " "
                    string += unit[t - 1]
                }
                if (t in 11..19) {
                    string += " "
                    string += eleven[t - 11]
                }
                if (t in 10..90 && t % 10 == 0) {
                    string += " "
                    string += ten[t / 10 - 1]
                }
                if (t in 21..99 && t % 10 != 0) {
                    val q = t / 10 * 10
                    string += " "
                    string += ten[q / 10 - 1]
                    string += " "
                    string += unit[t % 10 - 1]
                }
            }
        }
        if (n / 100 % 10 == 0) {
            val t = n % 100
            if (t < 10 && t != 0) {
                string += " "
                string += unit[t - 1]
            }
            if (t in 11..19) {
                string += " "
                string += eleven[t - 11]
            }
            if (t in 10..90 && t % 10 == 0) {
                string += " "
                string += ten[t / 10 - 1]
            }
            if (t in 21..99 && t % 10 != 0) {
                val q = t / 10 * 10
                string += " "
                string += ten[q / 10 - 1]
                string += " "
                string += unit[t % 10 - 1]
            }
        }
        return string
    }
    return string
}