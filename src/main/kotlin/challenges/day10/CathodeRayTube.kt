package challenges.day10

import java.io.File

class CathodeRayTube {

    companion object {
        private const val input = "./src/main/kotlin/challenges/day10/input.txt"

        fun computeResult() {
            val monitoredCycles = listOf(20, 60, 100, 140, 180, 220)
            var signalStrengths: MutableList<Pair<Int, Int>> = mutableListOf()
            var cycles = 1
            var registerX = 1
            File(input).forEachLine {
                if (it.startsWith("noop")) {
                    cycles++
                    signalStrengths.add(Pair(cycles, registerX))
                }
                if (it.startsWith("addx")) {
                    cycles++
                    signalStrengths.add(Pair(cycles, registerX))
                    cycles++
                    registerX += Integer.parseInt(it.substring("addx ".length))
                    signalStrengths.add(Pair(cycles, registerX))
                }
            }
            println(signalStrengths.filter { it.first in monitoredCycles }.sumOf { it.second * it.first })
        }

    }
}
