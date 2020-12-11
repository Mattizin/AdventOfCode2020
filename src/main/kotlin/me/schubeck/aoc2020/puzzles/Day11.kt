package me.schubeck.aoc2020.puzzles

import java.io.File

class Day11(inputFile: File) {

    private val inputSeatLayout = ArrayList<CharArray>()

    init {
        println("Advent of Code 2020 Day 11")
        inputFile.forEachLine { this.inputSeatLayout.add(it.toCharArray()) }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 11 Part 1")

        var currentSeatLayout = ArrayList<CharArray>()
        inputSeatLayout.forEach { currentSeatLayout.add(it.clone()) }
        var changing = true
        while(changing) {
            val newSeatLayout = ArrayList<CharArray>()
            currentSeatLayout.forEach { newSeatLayout.add(it.clone()) }
            changing = false
            for (i in 0 until currentSeatLayout.size) {
                for (j in currentSeatLayout[0].indices) {
                    when (currentSeatLayout[i][j]) {
                        '.' -> continue
                        'L' -> if (calculateAdjacentSeats(i, j, currentSeatLayout) == 0) {
                            newSeatLayout[i][j] = '#'
                            changing = true
                        }
                        '#' -> if (calculateAdjacentSeats(i, j, currentSeatLayout) >= 4) {
                            newSeatLayout[i][j] = 'L'
                            changing = true
                        }
                    }
                }
            }
            currentSeatLayout = ArrayList()
            newSeatLayout.forEach { currentSeatLayout.add(it.clone()) }
        }

        val occupiedSeats = currentSeatLayout.map { chars -> chars.count{ c -> c =='#' } }.sum()
        println("After the situation stabilized $occupiedSeats seats are occupied")
        return occupiedSeats
    }

    private fun calculateAdjacentSeats(seatRow: Int, seatColumn: Int, currentSeats: ArrayList<CharArray>) : Int {
        var adjacentSeats = 0

        for(i in -1..1) {
            //dont check if out of bounds in rows
            if(seatRow + i !in 0 until currentSeats.size) {
                continue
            }
            for(j in -1..1) {
                //Dont check for the seat itself
                if(i==0 && j == 0) {
                    continue
                }
                //dont check if out of bounds in columns
                if(seatColumn + j !in currentSeats[0].indices) {
                    continue
                }
                //Check if adjacent seat i, j is occupied
                if(currentSeats[seatRow + i][seatColumn + j] == '#') {
                    adjacentSeats++
                }
            }
        }

        return adjacentSeats
    }
}