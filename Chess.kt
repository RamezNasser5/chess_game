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

    //checkMovePawnValidation function to check the validation of pawn piece moving while
    private fun checkMovePawnValidation(expression: String,beforeMove: Int, afterMove: Int, indexOfPiece: Int,checkPlayer: Boolean): Boolean {
        if (this.rows[beforeMove][indexOfPiece] == ' ' && !checkPlayer){
            println("No black pawn at ${expression[0]}$beforeMove")
            return false
        }
        else if (this.rows[beforeMove][indexOfPiece] == ' ' && checkPlayer){
            println("No white pawn at ${expression[0]}$beforeMove")
            return false
        }
        else if (expression[0] != expression[2]){
            println("Invalid Input")
            return false
        }
        else if (this.rows[beforeMove][indexOfPiece] == 'W'){
            return if (beforeMove == 2 && afterMove == 4 || beforeMove == afterMove-1){
                true
            } else {
                println("Invalid Input")
                false
            }
        }
        else if (this.rows[beforeMove][indexOfPiece] == 'B'){
            return if (beforeMove == 7 && afterMove == 5 || beforeMove == afterMove+1){
                true
            } else {
                println("Invalid Input")
                false
            }
        }
        return false
    }

    //accessToPiece function use to reach to the piece we want to move it
    private fun accessToPiece(expression: String,beforeMove: Int, afterMove: Int, indexOfPiece: Int,checkPlayer: Boolean): Boolean {

        //if statement to check the validation of piece moving while moving from empty place or moving to wrong place
        if (checkMovePawnValidation(expression,beforeMove, afterMove, indexOfPiece,checkPlayer))
        {
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
        else {
            checkValidation = false
        }
        return checkValidation
    }

    //function pieceMoving use to move on piece to another in chess game
    fun pieceMoving(expression: String,checkPlayer: Boolean): Boolean {

        //beforeMove is a variable store a row number to move a piece from it to afterMove row
        val beforeMove = expression[1].code -48
        val afterMove = expression[3].code-48

        //when statement use to access a piece in beforeMove row and move it to afterMove row
        when(expression[0]) {
            'a' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,4,checkPlayer)
            }

            'b' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,8,checkPlayer)
            }

            'c' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,12,checkPlayer)
            }

            'd' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,16,checkPlayer)
            }

            'e' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,20,checkPlayer)
            }

            'f' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,24,checkPlayer)
            }

            'g' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,28,checkPlayer)
            }

            'h' -> {
                checkValidation = accessToPiece(expression,beforeMove,afterMove,32,checkPlayer)
            }
        }
        return checkValidation
    }
}
