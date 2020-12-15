package me.schubeck.aoc2020.puzzles

import java.io.File

class Day15(inputFile: File){

    private var rawInput : String

    init {
        println("Advent of Code 2020 Day 15")
        this.rawInput = inputFile.readLines()[0]
    }

    fun solvePuzzlePartI() : Int {
        println("Day 15 Part 1")

        var numbers = ArrayList<Int>()
        this.rawInput.split(",").forEach { s -> numbers.add(Integer.valueOf(s)) }

        for(turn in numbers.size+1..2020) {
            val lastNumber = numbers.last()
            if(numbers.count { i -> i == lastNumber } <= 1) {
                numbers.add(0)
            } else {
                val lastIndex = numbers.lastIndexOf(lastNumber)
                val lastBeforeLastIndex = numbers.subList(0, lastIndex).lastIndexOf(lastNumber)
                numbers.add(lastIndex - lastBeforeLastIndex)
            }
        }

        val solution = numbers.last()
        println("Last number spoken after 2020 turns: $solution")
        return solution
    }
}