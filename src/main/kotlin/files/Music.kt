package files


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

    var client: Int? = readlnOrNull()?.toIntOrNull();


    if (client == null || client <= 0 || client >= 3) {
        println("Неправильный выбор!")
        return

    } else if (client == 2) {
        println("Сколько хотите потратить на музыку: ")
        val moneySpent: Double? = readlnOrNull()?.toDoubleOrNull()
        nonRegularClient(moneySpent)
    } else if (client == 1) {
        println("Сколько хотите потратить на музыку: ")
        val moneySpent: Double? = readlnOrNull()?.toDoubleOrNull()
        regularClient(moneySpent)


    }
}

fun onePercentDiscount(amount: Double): Double {
    return amount * ONE_PERCENT
}

fun fivePercentDiscount(amount: Double): Double {
    return amount * FIVE_PERCENT
}

fun toPayOnePercent(moneySpent: Double?): Double? {
    return moneySpent?.minus(onePercentDiscount(moneySpent))
}

fun toPayFivePercent(moneySpent: Double?): Double? {
    return moneySpent?.minus(fivePercentDiscount(moneySpent))
}

fun nonRegularClient(moneySpent: Double?) {
    if (moneySpent == null || moneySpent <= 0) {
        println("Ничего не потратили.")
    } else if (moneySpent in 1.0..NO_DISCOUNT.toDouble()) {
        println(
            """У Вас нет скидки
                |Сумма к оплате: $moneySpent
            """.trimMargin()
        )
    } else if (moneySpent in NO_DISCOUNT.toDouble()..FIRST_DISCOUNT.toDouble()) {
        println(
            """Ваша скидка - 1%!
            |Она составит: ${onePercentDiscount(moneySpent.toDouble())} 
            |Сумма к оплате: ${toPayOnePercent(moneySpent)}
        """.trimMargin()
        )
    } else {
        println(
            """Ваша скидка - 5%! 
            |Она составит: ${fivePercentDiscount(moneySpent.toDouble())}
            |Сумма к оплате: ${toPayFivePercent(moneySpent)}""".trimMargin()
        )
    }
}

fun fivePercentRegularClient(fivePercentClient: Double): Double {
    var firstDiscount = fivePercentClient - (fivePercentClient * FIVE_PERCENT)
    var secondDiscount = firstDiscount - (firstDiscount * ONE_PERCENT)
    return fivePercentClient - secondDiscount

}

fun regularClient(moneySpent: Double?) {
    if (moneySpent == null || moneySpent <= 0) {
        println("Ничего не потратили.")
        return
    } else if (moneySpent in 1.0..NO_DISCOUNT.toDouble()) {
        println(
            """У Вас нет скидки
                |Сумма к оплате: $moneySpent
            """.trimMargin()
        )
    } else if (moneySpent in NO_DISCOUNT.toDouble()..FIRST_DISCOUNT.toDouble()) {
        val regularClientRegularPercent = (moneySpent - (onePercentDiscount(moneySpent.toDouble())))
        val regularClientAdditionalPercent =
            regularClientRegularPercent - onePercentDiscount(regularClientRegularPercent)
        val regularClientDiscountTotal = moneySpent - regularClientAdditionalPercent

        println(

            """Ваша скидка - 1%, и ещё 1% за то, что Вы частый клиент!
            |Она составит: $regularClientDiscountTotal
            |Сумма к оплате: $regularClientAdditionalPercent
            """.trimMargin()
        )
    } else {
        val totalPaymentRegularClientFivePercent = moneySpent.minus(fivePercentRegularClient(moneySpent))
        println(
            """Ваша скидка - 5%, и ещё 1% за то, что Вы частый клиент! 
            |Она составит: ${fivePercentRegularClient(moneySpent)}
            |Сумма к оплате: $totalPaymentRegularClientFivePercent
            """.trimMargin()
        )
    }
}

