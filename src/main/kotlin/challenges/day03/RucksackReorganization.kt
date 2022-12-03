package challenges.day03

import java.io.File


class RucksackReorganization {
    companion object {
        private val input = "./src/main/kotlin/challenges/day03/input.txt"

        fun computeResult() {
            var priority = 0
            val group = mutableListOf<String>()
            File(input).forEachLine {
                group.add(it)
                if (group.size == 3) {
                    val duplicateChar = group[0].find {
                        group[1].contains(it)
                                && group[2].contains(it)
                    }
                    priority += getAlphabeticalNmber(duplicateChar!!)
                    group.removeAll(group)
                }
            }
            println(priority)
        }

        private fun getAlphabeticalNmber(letter: Char): Int {
            if (letter in 'A'..'Z') return (letter.code - 'A'.code + 27)
            if (letter in 'a'..'z') return (letter.code - 'a'.code + 1)
            return 0
        }

    }
}
