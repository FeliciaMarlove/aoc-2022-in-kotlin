package challenges.day01

import java.io.File

class CalorieCounting {
    companion object {
        private val input = "./src/main/kotlin/challenges/day01/input.txt"
        private val elvesCalorieIntake = mutableListOf<Int>()
        fun computeResult() {
            var count = 0
            File(input).forEachLine {
                if (it.isNotEmpty()) {
                    count += Integer.parseInt(it)
                } else {
                    elvesCalorieIntake.add(count)
                    count = 0
                }
            }
            print(elvesCalorieIntake.max())
        }
    }
}
