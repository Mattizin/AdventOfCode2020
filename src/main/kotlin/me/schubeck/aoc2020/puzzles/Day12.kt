package me.schubeck.aoc2020.puzzles

import java.io.File
import kotlin.math.abs

class Day12(inputFile: File){

    private val actions = ArrayList<Pair<String, Int>>()

    init {
        println("Advent of Code 2020 Day 12")
        inputFile.forEachLine { line -> this.actions.add(Pair(line.substring(0,1), Integer.valueOf(line.substring(1))))}
    }

    fun solvePuzzlePartI() : Int {
        println("Day 12 Part 1")
        val directions = listOf("N","E","S","W")
        var curDir = 1
        var x = 0
        var y = 0

        for(action in this.actions) {
            when(action.first) {
                "N" -> y += action.second
                "S" -> y -= action.second
                "E" -> x += action.second
                "W" -> x -= action.second
                "L" -> {
                    val turns = (action.second % 360) / 90
                    if (curDir - turns < 0) {
                        curDir = directions.size - abs(curDir -turns)
                    } else {
                        curDir -= turns
                    }
                }
                "R" -> {
                    val turns = (action.second % 360) / 90
                    if(curDir + turns >= directions.size) {
                        curDir = abs((directions.size - curDir) - turns)
                    } else {
                        curDir += turns
                    }
                }
                "F" -> when(directions[curDir]) {
                    "N" -> y += action.second
                    "S" -> y -= action.second
                    "E" -> x += action.second
                    "W" -> x -= action.second
                }
            }
        }

        println("Endpoint after going through all actions: $x : $y")
        val solution = abs(x) + abs(y)
        println("Manhattan distance solution: $solution")
        return solution
    }

    fun solvePuzzlePartII() : Int {
        println("Day 12 Part 2")
        var pX = 10
        var pY = 1
        var shipX = 0
        var shipY = 0

        for(action in this.actions) {
            when(action.first) {
                "N" -> pY += action.second
                "S" -> pY -= action.second
                "E" -> pX += action.second
                "W" -> pX -= action.second
                "L" -> {
                    val turns = (action.second % 360) / 90
                    for(i in 1..turns) {
                        val tmp = pX
                        pX = (-1) * pY
                        pY = tmp
                    }
                }
                "R" -> {
                    val turns = (action.second % 360) / 90
                    for(i in 1..turns) {
                        val tmp = pX
                        pX = pY
                        pY = (-1) * tmp
                    }
                }
                "F" -> {
                    shipX += action.second * pX
                    shipY += action.second * pY
                }
            }
        }

        println("Endpoint after going through all actions: $shipX : $shipY")
        val solution = abs(shipX) + abs(shipY)
        println("Manhattan distance solution: $solution")
        return solution
    }
}