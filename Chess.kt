import kotlin.math.abs
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
    private fun checkMovePawnValidation(
        expression: String,beforeMove: Int, afterMove: Int, beforeMoveIndexPiece: Int, afterMoveIndexPiece: Int,checkPlayer: Boolean
    ): Boolean {
        if (expression[0] != expression[2]){
            return if (checkPlayer && this.rows[afterMove][afterMoveIndexPiece] == 'B' && abs(afterMoveIndexPiece-beforeMoveIndexPiece) == 4)
                true
            else if (!checkPlayer && this.rows[afterMove][afterMoveIndexPiece] == 'W' && abs(afterMoveIndexPiece-beforeMoveIndexPiece) == 4)
                true
            else {
                println("Invalid Input")
                false
            }

        }
        else if (this.rows[afterMove][afterMoveIndexPiece] != ' '){
            println("Invalid Input")
            return false
        }
        else if (checkPlayer && this.rows[beforeMove][beforeMoveIndexPiece] == 'B')
        {
            println("No white pawn at ${expression[0]}$beforeMove")
            return false
        }
        else if (!checkPlayer && this.rows[beforeMove][beforeMoveIndexPiece] == 'W')
        {
            println("No black pawn at ${expression[0]}$beforeMove")
            return false
        }
        if (this.rows[beforeMove][beforeMoveIndexPiece] == ' ' && !checkPlayer){
            println("No black pawn at ${expression[0]}$beforeMove")
            return false
        }
        else if (this.rows[beforeMove][beforeMoveIndexPiece] == ' ' && checkPlayer){
            println("No white pawn at ${expression[0]}$beforeMove")
            return false
        }
        else if (this.rows[beforeMove][beforeMoveIndexPiece] == 'W'){
            return if (beforeMove == 2 && afterMove == 4 || beforeMove == afterMove-1){
                true
            } else {
                println("Invalid Input")
                false
            }
        }
        else if (this.rows[beforeMove][beforeMoveIndexPiece] == 'B'){
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
    private fun accessToPiece(
        expression: String,beforeMove: Int, afterMove: Int, beforeMoveIndexPiece: Int, afterMoveIndexPiece: Int,checkPlayer: Boolean
    ): Boolean {

        //if statement to check the validation of piece moving while moving from empty place or moving to wrong place
        if (checkMovePawnValidation(expression,beforeMove, afterMove, beforeMoveIndexPiece, afterMoveIndexPiece,checkPlayer))
        {
            checkValidation = true
            this.rows[afterMove] = """${
                this.rows[afterMove].substring(
                    0,
                    afterMoveIndexPiece
                )
            }${this.rows[beforeMove][beforeMoveIndexPiece]}${this.rows[afterMove].substring(afterMoveIndexPiece + 1)}""".trimMargin()
            this.rows[beforeMove] = """${
                this.rows[beforeMove].substring(
                    0,
                    beforeMoveIndexPiece
                )
            } ${this.rows[beforeMove].substring(beforeMoveIndexPiece + 1)}""".trimMargin()
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
        var beforeMoveIndexPiece = 0
        var afterMoveIndexPiece = 0

        //when statement use to access a piece in beforeMove row and move it to afterMove row
        when(expression[0]) {
            'a' -> {
                beforeMoveIndexPiece = 4
            }

            'b' -> {
                beforeMoveIndexPiece = 8
            }

            'c' -> {
                beforeMoveIndexPiece = 12
            }

            'd' -> {
                beforeMoveIndexPiece = 16
            }

            'e' -> {
                beforeMoveIndexPiece = 20
            }

            'f' -> {
                beforeMoveIndexPiece = 24
            }

            'g' -> {
                beforeMoveIndexPiece = 28
            }

            'h' -> {
                beforeMoveIndexPiece = 32
            }
        }
        when(expression[2]) {
            'a' -> {
                afterMoveIndexPiece = 4
            }

            'b' -> {
                afterMoveIndexPiece = 8
            }

            'c' -> {
                afterMoveIndexPiece = 12
            }

            'd' -> {
                afterMoveIndexPiece = 16
            }

            'e' -> {
                afterMoveIndexPiece = 20
            }

            'f' -> {
                afterMoveIndexPiece = 24
            }

            'g' -> {
                afterMoveIndexPiece = 28
            }

            'h' -> {
                afterMoveIndexPiece = 32
            }
        }
        return accessToPiece(expression,beforeMove,afterMove,beforeMoveIndexPiece,afterMoveIndexPiece,checkPlayer)
    }
}
