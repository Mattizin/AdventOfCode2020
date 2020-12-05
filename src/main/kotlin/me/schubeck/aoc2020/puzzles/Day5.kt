package me.schubeck.aoc2020.puzzles

import java.io.File

class Day5(inputFile: File) {

    private val seatIds =  ArrayList<Int>()

    init {
        println("Advent of Code 2020 Day 5")
        /*
        Read boarding passes and calculate seat Ids
         */
        inputFile.forEachLine {
            val row = calculateIndexByBinaryDesc(it.substring(0,7), 0..127)
            val column = calculateIndexByBinaryDesc(it.substring(7), 0..7)
            val seatId = row*8+column
//            println("Pass points to seat ID $seatId with row $row and column $column")
            seatIds.add(seatId)
        }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 5 Part 1")
        /*
        Return the highest seatId
         */
        println("Max Seat ID of all passes: ${seatIds.maxOrNull() ?: -1}")
        return seatIds.maxOrNull() ?: -1
    }

    fun solvePuzzlePartII() : Int {
        println("Day 5 Part 2")
        var takenSeatsSorted = seatIds.sorted()
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