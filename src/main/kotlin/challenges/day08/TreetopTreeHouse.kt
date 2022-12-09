package challenges.day08

import java.io.File

// Row, Column, Height
typealias Tree = Triple<Int, Int, Int>

class TreetopTreeHouse {
    companion object {
        private const val input = "./src/main/kotlin/challenges/day08/input.txt"

        fun computeResult() {
            val lines: MutableList<List<Int>> = mutableListOf()
            File(input).forEachLine {
                lines.add(it.map { it.digitToInt() }.toList())
            }

            val forest: List<Set<Tree>> = lines.mapIndexed { index, line ->
                line.mapIndexed { jindex, lineItem ->
                    Tree(index, jindex, lineItem)
                }.toSet()
            }.toList()

            val visibleTrees: MutableSet<Tree> = mutableSetOf()

            forest.forEach {
                it.forEach {
                    if (it.first == 0
                        || it.second == 0
                        || it.first == forest.lastIndex
                        || it.second == forest[0].size - 1
                    ) visibleTrees.add(it)
                }
            }

            println(visibleTrees)
            println(visibleTrees.size)
        }


    }
}

