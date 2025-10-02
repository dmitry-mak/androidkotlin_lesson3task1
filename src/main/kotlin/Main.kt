package ru.netology.kotlin.functions

fun main() {
}

fun agoToText(time: Long): String {
    val minutes = time / 60
    val hours = time / 3600

    return when {
        (time <= 60) -> "Был(а) только что"
        (time > 60 && time <= 3599) -> """"Был(а) $minutes ${minutesCorrectForm(minutes.toInt())} назад """
        (time >= 3600 && time < 86400) -> """Был(а) $hours ${hoursCorrectForm(hours.toInt())} назад"""
        (time >= 86400 && time < 86400 * 2) -> """Был(а) вчера"""
        (time >= 86400 * 2 && time < 86400 * 3) -> """Был(а) позавчера"""
        else -> {
            "Был(а) давно"
        }
    }
}

fun minutesCorrectForm(minutes: Int): String {
    val lastDigit = minutes % 10
    val lastTwoDigits = minutes % 100
    return when {
        lastDigit == 1 && lastTwoDigits != 11 -> "минуту"
        lastDigit in 2..4 && lastTwoDigits !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun hoursCorrectForm(hours: Int): String {
    return when {
        hours == 1 || hours == 21 -> "час"
        hours in 2..4 || hours in 22..24 -> "часа"
        else -> "часов"
    }

}


