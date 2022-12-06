package challenges.day06

import java.io.File

class TuningTrouble {
    companion object {
        private const val input = "./src/main/kotlin/challenges/day06/input.txt"

        fun computeResult() {
            var position = 0
            File(input).forEachLine {
                for (i in 0 until it.toCharArray().size - 4) {
                    if (listOf(it[i], it[i + 1], it[i + 2], it[i + 3]).toSet().size == 4) {
                        position = i + 4
                        break
                    }
                }
            }
            print(position)
        }

    }
}
