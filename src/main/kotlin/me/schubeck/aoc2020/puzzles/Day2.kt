package me.schubeck.aoc2020.puzzles

import java.io.File

class Day2 (private val inputFile: File) {

    init {
        println("Advent of Code 2020 Day 2")
    }

    fun solvePuzzlePart1() : Int {
        println("Day 2 Part 1")

        val passwords = ArrayList<String>()
        inputFile.forEachLine { passwords.add(it) }
        var correctPws = 0

        for(pw in passwords) {
            val splitted = pw.split(" ")
            val minmax = splitted[0].split("-")
            val min = Integer.valueOf(minmax[0])
            val max = Integer.valueOf(minmax[1])
            val char = splitted[1][0]
            val pwText = splitted[2]

//            println("Line with min $min max $max char $char pwText $pwText")

            if(pwText.count { c -> c == char } in min..max) {
                correctPws++
            }
        }

        println("Correct passwords: $correctPws")
        return correctPws;
    }
}