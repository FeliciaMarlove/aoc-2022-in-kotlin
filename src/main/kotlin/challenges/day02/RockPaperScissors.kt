package challenges.day02

import java.io.File

class RockPaperScissors {
    companion object {
        private val input = "./src/main/kotlin/challenges/day02/input.txt"
        private val pointsPerShape = mapOf(
            'A' to 1, 'X' to 1,
            'B' to 2, 'Y' to 2,
            'C' to 3, 'Z' to 3
        )
        fun computeResult() {
            var score = 0
            File(input).forEachLine {
                val opponent = it[0]
                val me = it[2]
                score += playChifoumi(opponent, me) + pointsPerShape[me]!!
            }
            print(score)
        }

        private fun playChifoumi(opponent: Char, me: Char): Int {
            val win = 6
            val lose = 0
            val draw = 3

            if (opponent == 'C' && me == 'X'
                || opponent == 'A' && me == 'Y'
                || opponent == 'B' && me == 'Z') return win

            if (opponent == 'A' && me == 'X'
                || opponent == 'B' && me == 'Y'
                || opponent == 'C' && me == 'Z') return draw

            return lose
        }
    }
}
