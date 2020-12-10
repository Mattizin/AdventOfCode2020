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

    /*
    Honestly i was kinda lost at this task.
    I created the recursive brute force method traverseJoltages below
    which worked successfully on the testdata.
    I let it run for ~11 hours on the real puzzle input before cancelling the task
    I then seeked reddit.com/r/adventofcode for help and
    with solutions posted their came up with the algo below.
     */
    fun solvePuzzlePartII() : Long {
        println("Day 10 Part 2")
        this.outputJoltages.add(0)
        this.outputJoltages.add(this.outputJoltages.maxOrNull()!! + 3)
        var sortedJoltages = this.outputJoltages.sorted()

        val dp = LongArray(sortedJoltages.size)
        dp[0] = 1
        for (i in 0 until dp.size-1) {
            for (j in 1..3) {
                if (i+j >= dp.size) continue
                if (sortedJoltages[i + j] <= sortedJoltages[i] + 3) dp[i+j] += dp[i]
            }
        }
        println("Possibilites to connect the adapters: ${dp.last()}")
        return dp.last()
    }

    private fun traverseJoltages(start: Int, joltages: List<Int>) : Long {
        var possibilities : Long = 0
        if(joltages.isEmpty()) {
            return 1
        }
        var index = 0
        while(index < 3 && index <joltages.size) {
            if(joltages[index] - start <= 3) {
                possibilities += traverseJoltages(joltages[index], joltages.subList(index+1, joltages.size))
            }
            index++
        }

        return possibilities
    }
}