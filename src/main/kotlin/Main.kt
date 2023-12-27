import files.music

fun main() {
    println(
        """Выберите операцию: 
        |1. ДЗ 1-1
        |2. ДЗ 1-2
        |3. ДЗ 1-3
    """.trimMargin()
    )
    var userChoice: String? = readLine();

    userChoice = if (userChoice == "1")
        commission().toString()
    else if (userChoice == "2") likes().toString()
    else if (userChoice == "3") music().toString()
    else return
}