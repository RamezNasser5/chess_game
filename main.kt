
fun main() {
    //object chess from class Chess use to treat with chess form
    val chess = Chess()
    println(" Pawns-Only Chess")
    println("First Player's name:")

    //the name of first player
    val firstName = readln()
    println("Second Player's name:")

    //the name of second player
    val secondName = readln()
    chess.drawChess()

    //checkPlayer use to switch between two players
    var checkPlayer = 0

    //regex variable use to check the validation of player move
    var regex: Regex
    while (true) {
        if (checkPlayer % 2 == 0) {
            println(message = "$firstName's turn:")

            //firstPlayerMove variable is the first player move
            val firstPlayerMove = readln()
            if (firstPlayerMove == "exit") {
                println("Bye!")
                break
            } else {
                regex = Regex("[a-h][1-8][a-h][1-8]")
                if (regex.matches(firstPlayerMove)) {
                    if (chess.pieceMoving(firstPlayerMove)) {
                        chess.drawChess()
                    }
                    else
                    {
                        continue
                    }
                    checkPlayer++
                } else {
                    println("Invalid Input")
                }
            }
        } else {
            println("$secondName's turn:")

            //secondPlayerMove variable is the second player move
            val secondPlayerMove = readln()
            if (secondPlayerMove == "exit") {
                println("Bye!")
                break
            } else {
                regex = Regex("[a-h][1-8][a-h][1-8]")
                if (regex.matches(secondPlayerMove)) {
                    if (chess.pieceMoving(secondPlayerMove)) {
                        chess.drawChess()
                    }
                    checkPlayer++
                } else {
                    println("Invalid Input")
                }
            }
        }
    }
}
