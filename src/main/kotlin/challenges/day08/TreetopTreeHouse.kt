package challenges.day08

import java.io.File

typealias Tree = Triple<Int, Int, Int>

class TreetopTreeHouse {
    companion object {
        private const val input = "./src/main/kotlin/challenges/day08/input.txt"

        fun computeResult() {
            var totalVisibleTrees = 0
            val lines: MutableList<List<Int>> = mutableListOf()
            File(input).forEachLine {
                lines.add(it.map { it.digitToInt() }.toList())
            }

            var forest = lines.mapIndexed { index, line ->
                line.mapIndexed { jindex, lineItem ->
                    Tree(index, jindex, lineItem)
                }.toSet()
            }.toList()


            totalVisibleTrees += forest.size * 2
            totalVisibleTrees += (forest.get(0).size - 2) * 2

        }
    }
}
