package challenges.day03

import java.io.File


class RucksackReorganization {
    companion object {
        private val input = "./src/main/kotlin/challenges/day03/input.txt"

        fun computeResult() {
            var priority = 0
            File(input).forEachLine {
                val rucksack1 = it.subSequence(0, it.length / 2)
                val rucksack2 = it.subSequence(it.length / 2, it.length)
                val duplicateChar = rucksack2.find { rucksack1.contains(it) }
                priority += getAlphabeticalNmber(duplicateChar!!)
            }
            println(priority)
        }

        private fun getAlphabeticalNmber(letter: Char): Int {
            if (letter in 'A'..'Z') return(letter.code - 'A'.code + 27)
            if (letter in 'a'..'z') return(letter.code - 'a'.code + 1)
            return 0
        }

    }
}
