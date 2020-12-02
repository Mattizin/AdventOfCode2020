package me.schubeck.aoc2020.puzzles

import java.io.File

class Day2 (private val inputFile: File) {

    private val passwords = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 2")
        inputFile.forEachLine { passwords.add(it) }
    }

    fun solvePuzzlePart1() : Int {
        println("Day 2 Part 1")
        var correctPws = 0

        for(pw in passwords) {
            val (indices, charString, pwText) = pw.split(" ")
            val (min, max) = indices.split("-").map { s -> Integer.valueOf(s) }

//            println("Line with min $min max $max char $char pwText $pwText")

            if(pwText.count { c -> c == charString[0] } in min..max) {
                correctPws++
            }
        }

        println("Correct passwords: $correctPws")
        return correctPws;
    }

    fun solvePuzzlePart2() : Int {
        println("Day 2 Part 2")
        var correctPws = 0

        for(pw in passwords) {
            val (indices, charString, pwText) = pw.split(" ")
            val (first, second) = indices.split("-").map { s -> Integer.valueOf(s) }

//            println("Line with first $first second $second char $charString[0] pwText $pwText")

            if((pwText[first-1] == charString[0]).xor(pwText[second-1] == charString[0])) {
                correctPws++
            }
        }

        println("Correct passwords: $correctPws")
        return correctPws;
    }
}