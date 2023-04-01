class Chess {

    //this a mutable list to store a strings to draw chess form
    private var rows: MutableList<String>

    //this constructor to initialize the private mutable list rows
    init {
        rows = mutableListOf(
            "    a   b   c   d   e   f   g   h  ","1 |   |   |   |   |   |   |   |   |",
            "2 | W | W | W | W | W | W | W | W |","3 |   |   |   |   |   |   |   |   |",
            "4 |   |   |   |   |   |   |   |   |","5 |   |   |   |   |   |   |   |   |",
            "6 |   |   |   |   |   |   |   |   |","7 | B | B | B | B | B | B | B | B |",
            "8 |   |   |   |   |   |   |   |   |"
        )
    }

    //function drawChess use to draw the shape of chess
    fun drawChess()
    {
        //print("\u001b[H\u001b[2J")
        for (i in 8 downTo 0)
        {
            println("  +---+---+---+---+---+---+---+---+")
            println(rows[i])
        }
    }

    //function editForm use to move on piece to another in chess game
    fun editForm(expression: String) {

        //beforeMove is a variable store a row number to move a piece from it to afterMove row
        val beforeMove = expression[1].code -48
        val afterMove = expression[3].code-48

        //when use to access a piece in beforeMove row and move it to afterMove row
        when(expression[0]) {
            'a' -> {
              this.rows[afterMove] = this.rows[afterMove].substring(0, 4) + this.rows[beforeMove][4] + this.rows[afterMove].substring(5)
              this.rows[beforeMove] = this.rows[beforeMove].substring(0, 4) + " " + this.rows[beforeMove].substring(5)
            }

            'b' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 8) + this.rows[beforeMove][8] + this.rows[afterMove].substring(9)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 8) + " " + this.rows[beforeMove].substring(9)
            }

            'c' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 12) + this.rows[beforeMove][12] + this.rows[afterMove].substring(13)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 12) + " " + this.rows[beforeMove].substring(13)

            }

            'd' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 16) + this.rows[beforeMove][16] + this.rows[afterMove].substring(17)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 16) + " " + this.rows[beforeMove].substring(17)

            }

            'e' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 20) + this.rows[beforeMove][20] + this.rows[afterMove].substring(21)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 20) + " " + this.rows[beforeMove].substring(21)

            }

            'f' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 24) + this.rows[beforeMove][24] + this.rows[afterMove].substring(25)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 24) + " " + this.rows[beforeMove].substring(25)
            }

            'g' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 28) + this.rows[beforeMove][28] + this.rows[afterMove].substring(29)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 28) + " " + this.rows[beforeMove].substring(29)

            }

            'h' -> {
                this.rows[afterMove] = this.rows[afterMove].substring(0, 32) + this.rows[beforeMove][32] + this.rows[afterMove].substring(33)
                this.rows[beforeMove] = this.rows[beforeMove].substring(0, 32) + " " + this.rows[beforeMove].substring(33)
            }
        }
    }
}
