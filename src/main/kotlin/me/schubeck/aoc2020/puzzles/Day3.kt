package me.schubeck.aoc2020.puzzles

import java.io.File

class Day3 (private val inputFile: File){

    private val area = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 3")
        inputFile.forEachLine { area.add(it) }
    }

    fun solvePuzzlePart1() : Int {
        println("Day 3 Part 1")
        var treesPassed = 0
        val right = 3
        var curX = 0

        for(s in area) {
            //Check for tree
            if(s[curX] == '#') {
                treesPassed++
            }
            /* Move forward, set index to "start" when reaching end */
            curX+= right
            if(curX >= s.length) {
                curX-= s.length
            }
        }

        println("Passed $treesPassed trees!")
        return treesPassed
    }
}