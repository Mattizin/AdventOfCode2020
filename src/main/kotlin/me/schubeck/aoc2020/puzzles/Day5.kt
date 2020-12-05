package me.schubeck.aoc2020.puzzles

import java.io.File

class Day5(inputFile: File) {

    private val boardingPasses = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 5")
        inputFile.forEachLine { this.boardingPasses.add(it)}
    }

    fun solvePuzzlePartI() : ArrayList<Int> {
        /*
        Calculate Seat iDs and return the highest
         */
        var seatIds = ArrayList<Int>()

        for(boardingPass in boardingPasses) {
            val row = calculateIndexByBinaryDesc(boardingPass.substring(0,7), 0..127)
            val column = calculateIndexByBinaryDesc(boardingPass.substring(7), 0..7)
            val seatId = row*8+column
//            println("Pass points to seat ID $seatId with row $row and column $column")
            seatIds.add(seatId)
        }

        println("Max Seat ID of all passes: ${seatIds.maxOrNull() ?: -1}")
        return seatIds
    }

    fun solvePuzzlePartII() : Int {
        var takenSeatsSorted = solvePuzzlePartI()
        val i = takenSeatsSorted.iterator()
        while(i.hasNext()) {
            var curSeatId = i.next()
            if(takenSeatsSorted.contains(curSeatId+2).and(!takenSeatsSorted.contains(curSeatId+1))) {
                println("Free seat at seat with Id ${curSeatId+1}")
                return curSeatId+1
            }
        }
        return -1
    }

    private fun calculateIndexByBinaryDesc(binaryDesc: String, startRange: IntRange) : Int {
        var range = startRange
        for(char in binaryDesc) {
            when(char) {
                'F','L' -> range = range.first until range.last-(range.last-range.first)/2
                'B','R' -> range = range.first+(range.last-range.first)/2+1..range.last
            }
        }
        return range.first
    }
}