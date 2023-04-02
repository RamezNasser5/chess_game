class Chess {

    //this a mutable list to store a strings to draw chess form
    private var rows: MutableList<String>
    private var checkValidation: Boolean

    //this constructor to initialize the private mutable list rows
    init {
        rows = mutableListOf(
            "    a   b   c   d   e   f   g   h  ","1 |   |   |   |   |   |   |   |   |",
            "2 | W | W | W | W | W | W | W | W |","3 |   |   |   |   |   |   |   |   |",
            "4 |   |   |   |   |   |   |   |   |","5 |   |   |   |   |   |   |   |   |",
            "6 |   |   |   |   |   |   |   |   |","7 | B | B | B | B | B | B | B | B |",
            "8 |   |   |   |   |   |   |   |   |"
        )
        checkValidation = true
    }

    //function drawChess use to draw the shape of chess
    fun drawChess()
    {
        for (i in 8 downTo 0)
        {
            println("  +---+---+---+---+---+---+---+---+")
            println(rows[i])
        }
    }

    //accessToPiece function use to reach to the piece we want to move it
    private fun accessToPiece(expression: String,beforeMove: Int, afterMove: Int, indexOfPiece: Int): Boolean {
        if (this.rows[beforeMove][indexOfPiece] == ' ')
        {
            println("No black pawn at ${expression[0]}$beforeMove")
            checkValidation = false
        }
        else {
            checkValidation = true
            this.rows[afterMove] = """${
                this.rows[afterMove].substring(
                    0,
                    indexOfPiece
                )
            }${this.rows[beforeMove][indexOfPiece]}${this.rows[afterMove].substring(indexOfPiece + 1)}""".trimMargin()
            this.rows[beforeMove] = """${
                this.rows[beforeMove].substring(
                    0,
                    indexOfPiece
                )
            } ${this.rows[beforeMove].substring(indexOfPiece + 1)}""".trimMargin()
        }
        return checkValidation
    }

    //function pieceMoving use to move on piece to another in chess game
    fun pieceMoving(expression: String): Boolean {

        //beforeMove is a variable store a row number to move a piece from it to afterMove row
        val beforeMove = expression[1].code -48
        val afterMove = expression[3].code-48

        //when statement use to access a piece in beforeMove row and move it to afterMove row
        when(expression[0]) {
            'a' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,4)
            }

            'b' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,8)
            }

            'c' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,12)
            }

            'd' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,16)
            }

            'e' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,20)
            }

            'f' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,24)
            }

            'g' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,28)
            }

            'h' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,32)
            }
        }
        return checkValidation
    }
}
