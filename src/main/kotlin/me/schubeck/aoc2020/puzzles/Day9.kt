package me.schubeck.aoc2020.puzzles

import java.io.File

class Day9(inputFile: File) {

    private val inputNumbers = ArrayList<Long>()

    init {
        println("Advent of Code 2020 Day 9")
        inputFile.forEachLine { this.inputNumbers.add(it.toLong()) }
    }

    fun solvePuzzlePartI(numPreambleDigits: Int) : Long {
        println("Day 9 Part 1")
        var solution : Long = -1

        /*
        Iterate all input numbers via indices starting behind the preamble
         */
        inputNumberLoop@
        for(i in numPreambleDigits until inputNumbers.size) {
            val checkRange = inputNumbers.subList(i-numPreambleDigits, i)
            /*
            Iterate the sum of every preamble digit with every preamble digit except itself,
            continue outer loop when correct sum found
             */
            for(j in checkRange) {
                for(k in checkRange) {
                    if(j==k) {
                        continue
                    }
                    if(j+k == inputNumbers[i]) {
                        continue@inputNumberLoop
                    }
                }
            }
            /*
            Could not find a combination with the corecct sum
             */
            solution = inputNumbers[i]
            break;
        }

        println("First number which is not the sum of 2 number before in the preamble range of $numPreambleDigits: $solution")
        return solution
    }

    fun solvePuzzlePartII(numPreambleDigits: Int) : Long {
        println("Day 9 Part 2")
        var solution : Long = -1

        val invalidNumber = solvePuzzlePartI(numPreambleDigits)
        for(i in 0 until inputNumbers.size) {
            var sumRange = ArrayList<Long>()
            var testSum : Long = 0
            var index = i
            while (testSum < invalidNumber) {
                sumRange.add(inputNumbers[index])
                testSum += inputNumbers[index++]
            }
            if(testSum == invalidNumber) {
                val min = sumRange.minOrNull() ?: -1
                val max = sumRange.maxOrNull() ?: -1
                solution = min+max
                break;
            }
        }

        println("Sum of the smallest and largest number in the contiguous range representing the weakness in sum: $solution")
        return solution
    }
}