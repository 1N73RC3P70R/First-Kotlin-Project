fun likes(){
    println("""Введите количество отметок "Нравится": """)
    val input: Int? = readLine()?.toIntOrNull();

    if (input == null || input <= 0){
        println("Неправильный ввод.")
    } else {
        val likes = when {
            input == 0 -> "Никому пока не понравилось"
            input == 1 -> "Понравилось 1 человеку"
            input % 10 == 1 && input % 100 != 11 -> "Понравилось $input человеку"
            else -> "Понравилось $input людям"
        }
        println(likes)

    }

}
