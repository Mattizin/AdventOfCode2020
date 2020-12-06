package me.schubeck.aoc2020.puzzles

import java.io.File

class Day6(inputFile: File) {

    private val groupAnswers =  ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 6")
        /*
        read all lines, combine group answers into one string, but only once for each answered question
         */
        var tmpLine = ""
        inputFile.forEachLine {
            when {
                it.isBlank() -> {
                    groupAnswers.add(tmpLine)
                    tmpLine = ""
                }
                tmpLine.isEmpty() -> {
                    tmpLine = it
                }
                else -> {
                    for(char in it) {
                        if(!tmpLine.contains(char)) {
                            tmpLine += char
                        }
                    }
                }
            }
        }
        //Add Last group line
        groupAnswers.add(tmpLine)
    }

    fun solvePuzzlePartI() : Int {
        println("Day 6 Part 1")
        /*
        Count individual answers and add the counts up
         */
        val solution = groupAnswers.map { s -> s.count() }.reduce { acc, i -> acc + i }
        println("Sum of yes answers: $solution")
        return solution
    }
}