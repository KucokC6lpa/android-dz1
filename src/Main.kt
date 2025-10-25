//package tictactoe


fun printGrid(grid: Array<Char>) {        //функция печати добавлена
    println("---------")
    println("| ${grid[0]} ${grid[1]} ${grid[2]} |")
    println("| ${grid[3]} ${grid[4]} ${grid[5]} |")
    println("| ${grid[6]} ${grid[7]} ${grid[8]} |")
    println("---------")
}

fun main() {
    val inputStr = "         "
    val gridArray: Array<Char> = inputStr.toCharArray().toTypedArray()    //теперь вместо двумерного массива используется одномерный

    printGrid(gridArray)


    var isTheGameOver = false
    var isXTurn = true

    val winPositions = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
        listOf(0, 4, 8), listOf(2, 4, 6)
    )

    while (isTheGameOver == false) {

        println("Select a cell")
        val (inputX, inputY) = readln().split(" ")
        val x = inputX.toIntOrNull()
        val y = inputY.toIntOrNull()
        if ((x == null) || (y == null)) {
            println("You should enter numbers!")
            continue                                                 //continue доюавлены
        }
        if ((x < 1) || (x > 3) || (y < 1) || (y > 3)) {
            println("Coordinates should be from 1 to 3!")
            continue
        }
        if (gridArray[(x - 1) * 3 + y - 1] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        }
        if (isXTurn == true) {
            gridArray[(x - 1) * 3 + y - 1] = 'x'
            isXTurn = false
        } else {
            gridArray[(x - 1) * 3 + y - 1] = 'o'
            isXTurn = true
        }
        printGrid(gridArray)

        for (position in winPositions) {                  //условия победы переделаны
            val (a, b, c) = position
            if ((gridArray[a] != ' ') && (gridArray[a] == gridArray[b]) && (gridArray[a] == gridArray[c])) {
                val winner = gridArray[a]
                println("The winner is $winner")
                isTheGameOver = true
                break
            }
        }

        if (' ' in gridArray) {                            //проверка на ничью есть
            continue
        } else if(isTheGameOver == false){
            println("Draw")
            isTheGameOver = true
        }

    }

}