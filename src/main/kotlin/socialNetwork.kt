
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



fun min(name: String, sec: Int, secMesage: Int): String {
    return when {
        (sec in 60..119 || sec in 1260..1319 || sec in 1860..1919 || sec in 2460..2519 || sec in 3060..3119) -> "$name\nбыл(была) в сети минуту назад"
        (sec in 120..299 || sec in 1320..1499 || sec in 1920..2099 || sec in 2520..2699 || sec in 3120..3299) -> "$name\nбыл(была) в сети $secMesage минуты назад"
        (sec in 300..1259 || sec in 1500..1859 || sec in 2100..2459 || sec in 2700..3059 || sec in 3300..3599) -> "$name\nбыл(была) в сети $secMesage минут назад"
        else -> ({}).toString()
    }
}



fun hour(name: String, sec: Int, secMesage: Int): String {
    return when {
        (sec >= 60 * 60 && sec < 120 * 60 || sec >= 1260 * 60 && sec < 1320 * 60 || sec >= 1860 * 60 && sec < 1920 * 60 || sec >= 2460 * 60 && sec < 2520 * 60 || sec >= 3060 * 60 && sec < 3120 * 60) -> "$name\nбыл(была) в сети час назад"
        (sec >= 120 * 60 && sec < 300 * 60 || sec >= 1320 * 60 && sec < 1500 * 60 || sec >= 1920 * 60 && sec < 2100 * 60 || sec >= 2520 * 60 && sec < 2700 * 60 || sec >= 3120 * 60 && sec < 3300 * 60) -> "$name\nбыл(была) в сети $secMesage часа назад"
        (sec >= 300 * 60 && sec < 1260 * 60 || sec >= 1500 * 60 && sec < 1860 * 60 || sec >= 2100 * 60 && sec < 2460 * 60 || sec >= 2700 * 60 && sec < 3060 * 60 || sec >= 3300 * 60 && sec < 3600 * 60) -> "$name\nбыл(была) в сети $secMesage часов назад"
        else -> ({}).toString()
    }
}