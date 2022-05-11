fun main(args: Array<String>) {
    val names = arrayOf("Сергей", "Николай", "Елена", "Семен", "Федор", "Наталья", "Евгения", "Никита")
    val times = intArrayOf(3412, 272334, 28747, 3293367, 44526, 40343, 388, 25)
    for (i in names.indices) {
        println(agoToText(names[i], times[i]))
    }
}


fun agoToText(name: String, sec: Int): String {
    return when {
        (sec in 1..60) -> "$name\nбыл(была) в сети только что"
        (sec > 60 && sec <= 60 * 60) -> min(name, sec, sec / 60)
        (sec > 60 * 60 && sec <= 24 * 60 * 60) -> hour(name, sec, sec / 3600)
        (sec > 24 * 60 * 60 && sec <= 2 * 24 * 60 * 60) -> "$name\nбыл(была) в сети сегодня"
        (sec > 2 * 24 * 60 * 60 && sec <= 3 * 24 * 60 * 60) -> "$name\nбыл(была) в сети вчера"
        (sec > 3 * 24 * 60 * 60) -> "$name\nбыл(была) в сети давно"
        else -> ({}).toString()
    }
}

//1, 21, 31, 41, 51 минуту
//2-4, 22-24, 32-34, 42-44, 52-54 минуты
//5-20, 25-30, 35-40, 45-50, 55-59 минут

fun min(name: String, sec: Int, secMesage: Int): String {
    val y = sec / 60
    var m1 = 0
    var m2 = 0
    m1 = y % 10
    m2 = y % 100
    return when {
        (m2 in 10..20 || m2 in 25..30 || m2 in 35..40 || m2 in 45..50 || m2 in 55..59) -> "$name\nбыл(была) в сети $secMesage минут назад"
        (m1 == 1 && m2 < 10) -> "$name\nбыл(была) в сети минуту назад"
        (m1 == 1 && m2 > 10) -> "$name\nбыл(была) в сети $secMesage минуту назад"
        (m1 == 2 || m1 == 3 || m1 == 4 || m2 > 21) -> "$name\nбыл(была) в сети $secMesage минуты назад"
        (m1 >= 5 || m1 <= 9) -> "$name\nбыл(была) в сети $secMesage минут назад"
        else -> ({}).toString()
    }
}


//1, 21, 31, 41, 51 час
//2-4, 22-24, 32-34, 42-44, 52-54 часа
//5-20, 25-30, 35-40, 45-50, 55-59 часов

fun hour(name: String, sec: Int, secMesage: Int): String {
    val y = sec / 60 / 60
    var m1 = 0
    var m2 = 0
    m1 = y % 10
    m2 = y % 100
    return when {
        (m2 in 10..20 || m2 in 25..30 || m2 in 35..40 || m2 in 45..50 || m2 in 55..59) -> "$name\nбыл(была) в сети $secMesage часов назад"
        (m1 == 1 && m2 < 10) -> "$name\nбыл(была) в сети час назад"
        (m1 == 1 && m2 > 10) -> "$name\nбыл(была) в сети $secMesage час назад"
        (m1 == 2 || m1 == 3 || m1 == 4 || m2 > 21) -> "$name\nбыл(была) в сети $secMesage часа назад"
        (m1 >= 5 || m1 <= 9) -> "$name\nбыл(была) в сети $secMesage часов назад"
        else -> ({}).toString()
    }
}






