package challenges.day06

import java.io.File

class TuningTrouble {
    companion object {
        private const val input = "./src/main/kotlin/challenges/day06/input.txt"

        fun computeResult() {
            var position = 0
            File(input).forEachLine {
                for (i in 0 until it.toCharArray().size - 4) {
                    val shifts = mutableListOf<Char>()
                    for (j in 0..13) {
                        shifts.add(it[i + j])
                    }
                    if (shifts.toSet().size == 14) {
                        position = i + 14
                        break
                    }
                }
            }
            print(position)
        }

    }
}
