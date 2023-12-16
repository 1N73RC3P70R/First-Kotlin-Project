const val ONE_PERCENT = 0.01
const val FIVE_PERCENT = 0.05
const val NO_DISCOUNT = 1001
const val FIRST_DISCOUNT = 10_001
fun music() {

    println(
        """Вы частый клиент? 
        |1. Да
        |2. Нет
    """.trimMargin()
    )
    var client: Int? = readLine()?.toIntOrNull()
    if (client == null || client <= 0 || client >= 3) {
        println("Неправильный выбор.")
        return
    } else {

        println("""Сколько хотите потратить на музыку: """)
        var moneySpent: Int? = readLine()?.toInt()


        if (moneySpent == null || moneySpent <= 0) {
            println("Ничего не потратили.")
        } else if (moneySpent > 0 && moneySpent < NO_DISCOUNT) {
            if (client == 1) {
                var discount: Double = moneySpent - onePercent(moneySpent.toDouble())

                println(
                    """Ваша скидка - 1%, за то что Вы частый клиент!
                |Она составит: ${onePercent(moneySpent.toDouble())} 
                |Сумма к оплате: $discount
            """.trimMargin()
                )
            } else {
                println(
                    """У Вас нет скидки
                    |Сумма к оплате: $moneySpent
                """.trimMargin()
                )
            }


        } else if (moneySpent >= NO_DISCOUNT && moneySpent < FIRST_DISCOUNT) {
            var discount: Double = moneySpent - onePercent(moneySpent.toDouble())
            if (client == 1) {
                discount = onePercent(moneySpent.toDouble() + onePercent(moneySpent.toDouble()))
                var toPay: Double = moneySpent - onePercent(moneySpent.toDouble() + onePercent(moneySpent.toDouble()))

                println(
                    """Ваша скидка - 1%, и ещё 1% за то, что Вы частый клиент!
                |Она составит: $discount 
                |Сумма к оплате: $toPay
            """.trimMargin()
                )
            } else
                println(
                    """Ваша скидка - 1%!
            |Она составит: ${onePercent(moneySpent.toDouble())} 
            |Сумма к оплате: $discount
        """.trimMargin()
                )
        } else if (moneySpent >= FIRST_DISCOUNT) {
            var discount: Double = fivePercent(moneySpent.toDouble())
            var toPay: Double = moneySpent - fivePercent(moneySpent.toDouble())
            if (client == 1) {
                discount = fivePercentClient(moneySpent.toDouble())
                toPay = moneySpent - fivePercentClient(moneySpent.toDouble())
                println(
                    """Ваша скидка - 5%, и ещё 1% за то, что Вы частый клиент! 
            |Она составит: $discount
            |Сумма к оплате: $toPay""".trimMargin()
                )
            } else
                println(
                    """Ваша скидка - 5%! 
            |Она составит: $discount
            |Сумма к оплате: $toPay""".trimMargin()
                )
        }
    }
}

fun onePercent(onePercent: Double): Double {
    return onePercent * ONE_PERCENT
}

fun fivePercent(fivePercent: Double): Double {
    return fivePercent * FIVE_PERCENT
}

fun fivePercentClient(fivePercentClient: Double): Double {
    var firstDiscount = fivePercentClient - (fivePercentClient * FIVE_PERCENT)
    var secondDiscount = firstDiscount - (firstDiscount * ONE_PERCENT)
    return fivePercentClient -  secondDiscount

}
