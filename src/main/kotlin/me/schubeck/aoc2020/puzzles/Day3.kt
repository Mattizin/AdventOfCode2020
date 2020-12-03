package me.schubeck.aoc2020.puzzles

import java.io.File

class Day3 (inputFile: File){

    private val area = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 3")
        inputFile.forEachLine { area.add(it) }
    }

    fun solvePuzzlePart1() : Long {
        println("Day 3 Part 1")
        val treesPassed = traverseArea(3,1)
        println("Passed $treesPassed trees!")
        return treesPassed
    }

    fun solvePuzzlePart2() : Long {
        println("Day 3 Part 2")
        val slope1 = traverseArea(1,1)
        val slope2 = traverseArea(3,1)
        val slope3 = traverseArea(5,1)
        val slope4 = traverseArea(7,1)
        val slope5 = traverseArea(1,2)
        val solution = slope1*slope2*slope3*slope4*slope5
        println("Multiply trees passed: $solution")
        return solution
    }

    private fun traverseArea(right: Int, bottom: Int) : Long {
        var treesPassed: Long = 0
        var curX = 0
        var curY = 0

        while (curY < area.size) {
            /* Check for tree
            If curX >= length --> start from start with modulo */
            if(area[curY][curX % area[curY].length] == '#') {
                treesPassed++
            }
            // Move forward
            curX+= right
            curY+= bottom
        }

        return treesPassed
    }
}