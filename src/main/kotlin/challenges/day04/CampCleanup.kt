package challenges.day04

import java.io.File

class CampCleanup {
    companion object {
        private val input = "./src/main/kotlin/challenges/day04/input.txt"

        fun computeResult() {
            var count = 0
            File(input).forEachLine {
                val sections = it.split(',')
                val section1 = getSection(sections[0])
                val section2 = getSection(sections[1])

                if (section2.containsAll(section1)
                    || section1.containsAll(section2)
                ) count++
            }
            println(count)
        }

        private fun getSection(section: String): List<Int> {
            val bounds = section.split('-')
                .map { Integer.parseInt(it) }
            return (bounds[0]..bounds[1]).map { it + 1 }
        }
    }
}

