package me.schubeck.aoc2020.puzzles

import java.io.File

class Day10(inputFile: File) {

    private val outputJoltages = ArrayList<Int>()

    init {
        println("Advent of Code 2020 Day 10")
        inputFile.forEachLine { this.outputJoltages.add(Integer.valueOf(it)) }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 10 Part 1")
        var sortedJoltages = this.outputJoltages.sorted()
        var lastJoltage = 0
        /*
        Device Joltage always 3 higher as max in joltage list so theres min. 1 dif 3
         */
        var dif3 = 1
        var dif1 = 0

        for(joltage in sortedJoltages) {
            when(joltage - lastJoltage) {
                1 -> dif1++
                3 -> dif3++
            }
            lastJoltage = joltage
        }

        val solution = dif1 * dif3
        println("Joltage difference of 1: $dif1, difference of 3: $dif3. Solution = $solution")
        return solution
    }
}