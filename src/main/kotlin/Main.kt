fun main() {

    val minimumRate: Int = 35;
    val standardRate: Double = 0.0075;


    println("Введите сумму: ")
    var amount = readln().toDoubleOrNull();

    val commissionTotal = if (amount!! <= minimumRate) {
        println("$minimumRate  руб.")
    } else {
        println("${amount * standardRate}  руб.")
    }

}