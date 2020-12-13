package me.schubeck.aoc2020.puzzles

import java.io.File

class Day13(inputFile: File){

    private val departTimestamp: Int
    private val rawBusIds: List<String>
    private val busIds : List<Int>

    init {
        println("Advent of Code 2020 Day 13")
        val inputLines = inputFile.readLines()
        this.departTimestamp = Integer.valueOf(inputLines[0])
        this.rawBusIds = inputLines[1].split((","))
        this.busIds = this.rawBusIds.filter { s -> s != "x" }.map { s -> Integer.valueOf(s).or(0) }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 13 Part 1")

        var nextDepBusId = this.busIds[0]
        var timeToWait = this.busIds.maxOrNull() ?: 0

        for(busId in this.busIds) {
            val busGone = this.departTimestamp % busId
            if((busId - busGone) < timeToWait) {
                timeToWait = (busId - busGone)
                nextDepBusId = busId
            }
        }

        val solution = nextDepBusId * timeToWait
        println("Solution: $solution")
        return solution
    }

    fun solvePuzzlePartII() : Long {
        println("Day 13 Part 2")
        val busIdIndexPairs = ArrayList<Pair<Long, Int>>()

        for(i in this.rawBusIds.indices) {
            if(this.rawBusIds[i] != "x") {
                busIdIndexPairs.add(Pair(this.rawBusIds[i].toLong(), i))
            }
        }

        var timestamp : Long = 0
        var commonInterval = 1L
        for(busIdIndexPair in busIdIndexPairs) {
            while (true) {
                if ((timestamp + busIdIndexPair.second.toLong()) % busIdIndexPair.first == 0L) {
                    commonInterval *= busIdIndexPair.first;
                    break;
                }
                timestamp += commonInterval;
            }
        }

        println("Solution: $timestamp")
        return timestamp
    }
}