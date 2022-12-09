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

            // Add perimeter trees:
            forest.forEach {
                it.forEach {
                    if (it.first == 0
                        || it.second == 0
                        || it.first == forest.lastIndex
                        || it.second == forest[0].size - 1
                    ) visibleTrees.add(it)
                }
            }

            // Check trees inside perimeter:

            // TODO
            // tree visibility => 4 directions (only one must be OK, not the 4 of them!)
            // -> check all to the left -> (if not highest) check all to the right -> (if not highest) check all
            // upwards -> (if not highest) check all downwards
            // until -> downTo pour itérer dans l'autre sens

            println(visibleTrees)
            println(visibleTrees.size)
        }


    }
}

