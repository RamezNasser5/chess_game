

fun main() {
    //object chess from class Chess use to treat with chess form
    val chess = Chess()
    println("Pawns-Only Chess")
    println("First Player's name:")

    //the name of first player
    val firstName = readln()
    println("Second Player's name:")

    //the name of second player
    val secondName = readln()
    chess.drawChess()

    //checkPlayer use to switch between two players
    var checkPlayer = true

    //firstPlayerMove variable is the first player move
    var firstPlayerMove = "true"

    //secondPlayerMove variable is the second player move
    var secondPlayerMove = "true"

    //regex variable use to check the validation of player move
    var regex: Regex
    while (firstPlayerMove != "exit" || secondPlayerMove != "exit") {
        if (checkPlayer) {
            println(message = "$firstName's turn:")

            firstPlayerMove = readln()
            if (firstPlayerMove == "exit") {
                println("Bye!")
                break
            } else {
                regex = Regex("[a-h][1-8][a-h][1-8]")
                if (regex.matches(firstPlayerMove)) {
                    if (chess.pieceMoving(firstPlayerMove,checkPlayer)) {
                        checkPlayer = false
                        chess.drawChess()
                    }
                } else {
                    println("Invalid Input")
                }
            }
        } else {
            println("$secondName's turn:")

            //secondPlayerMove variable is the second player move
            secondPlayerMove = readln()
            if (secondPlayerMove == "exit") {
                println("Bye!")
                break
            } else {
                regex = Regex("[a-h][1-8][a-h][1-8]")
                if (regex.matches(secondPlayerMove)) {
                    if (chess.pieceMoving(secondPlayerMove,checkPlayer)) {
                        checkPlayer = true
                        chess.drawChess()
                    }
                } else {
                    println("Invalid Input")
                }
            }
        }
    }
}
