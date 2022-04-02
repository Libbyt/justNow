fun main() {
    println(agoToText(60*11))
}
const val minute = 60
const val hour = minute*60
const val day = hour*24

fun agoToText (second:Int):String {
    return when (second) {
        in 0..minute -> "только что"
        in minute+1..hour -> stringMinutes(second.div(minute))
        in hour+1..day -> stringHours(second.div(hour))
        in day+1..day*2 -> "сегодня"
        in day*2+1..day*3 -> "вчера"
        else -> "давно"
    }
}

fun stringMinutes (minutes:Int):String {
    if ((minutes == 1) ||  (minutes.mod(10) == 1) && minutes != 11) {
        return "$minutes минуту назад"
    } else if (minutes.mod(10) in 2..4) {
        return "$minutes минуты назад"
    } else return "$minutes минут назад"
}

fun stringHours(hours:Int):String {
    if ((hours == 1) ||  (hours.mod(10) == 1) && hours != 11) {
        return "$hours час назад"
    } else if (hours.mod(10) in 2..4) {
        return "$hours часа назад"
    } else return "$hours часов назад"
}