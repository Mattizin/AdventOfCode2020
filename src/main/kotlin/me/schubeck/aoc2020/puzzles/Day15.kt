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
        var inputNumbers = ArrayList<Int>()
        this.rawInput.split(",").forEach { s -> inputNumbers.add(Integer.valueOf(s)) }
        val solution = this.playMemoryGame(inputNumbers, 2020)
        println("Last number spoken after 2020 turns: $solution")
        return solution
    }

    fun solvePuzzlePartII() : Int {
        println("Day 15 Part 2")
        var inputNumbers = ArrayList<Int>()
        this.rawInput.split(",").forEach { s -> inputNumbers.add(Integer.valueOf(s)) }
        val solution = this.playMemoryGame(inputNumbers, 30_000_000)
        println("Last number spoken after 30.000.000 turns: $solution")
        return solution
    }

    private fun playMemoryGame(inputNumbers: ArrayList<Int>, numOfTurns: Int) : Int {
        /*
        Switch to map instead of Lists and sublists for calculating -> Much better performance
         */
        val map = hashMapOf<Int, Int>()
        for (i in inputNumbers.indices) map[inputNumbers[i]] = i
        var turns = inputNumbers.size + 1
        var lastSpoken = 0

        while (turns < numOfTurns) {
            if (map[lastSpoken] == null) {
                map[lastSpoken] = turns - 1
                lastSpoken = 0
            } else {
                val num = turns - 1 - map[lastSpoken]!!
                map[lastSpoken] = turns - 1
                lastSpoken = num
            }
            turns++
        }
        return lastSpoken
    }
}