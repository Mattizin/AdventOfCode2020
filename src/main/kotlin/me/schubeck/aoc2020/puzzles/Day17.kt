package me.schubeck.aoc2020.puzzles

import java.io.File

class Day17(inputFile: File){

    /*
    Coordinates to all 26 neighbours of a point in a 3 dimensional (x, y, z) grid
     */
    private val directions = listOf(
            //Same z level top left to bottom right
            Triple(-1, -1, 0),
            Triple(0, -1, 0),
            Triple(1, -1, 0),
            Triple(-1, 0, 0),
            //ignore own position
            Triple(1, 0, 0),
            Triple(-1,1,0),
            Triple(0,1,0),
            Triple(1,1,0),
            //zLevel -1
            Triple(-1, -1, -1),
            Triple(0, -1, -1),
            Triple(1, -1, -1),
            Triple(-1, 0, -1),
            Triple(0, 0, -1),
            Triple(1, 0, -1),
            Triple(-1,1,-1),
            Triple(0,1,-1),
            Triple(1,1,-1),
            //zLevel +1
            Triple(-1, -1, 1),
            Triple(0, -1, 1),
            Triple(1, -1, 1),
            Triple(-1, 0, 1),
            Triple(0, 0, 1),
            Triple(1, 0, 1),
            Triple(-1,1,1),
            Triple(0,1,1),
            Triple(1,1,1),
    )

    /*
    Maps 3 dimensional cube objects to active true/false status
     */
    private val inputCubeGrid = HashMap<Cube, Boolean>()
    private var startBounds : Triple<IntRange, IntRange, IntRange>

    init {
        println("Advent of Code 2020 Day 17")
        var y = 0
        inputFile.forEachLine {
            for(x in it.indices) {
                this.inputCubeGrid[Cube(x, y, 0)] = (it[x] == '#')
            }
            y++
        }
        this.startBounds = Triple(inputFile.readLines()[0].indices, 0..y, 0..0)
    }

    fun solvePuzzlePartI() : Int {
        println("Day 17 Part 1")

        var currentCubeGrid = HashMap<Cube, Boolean>()
        this.inputCubeGrid.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        //Iterate 6 times
        for(i in 1..6)  {
            val newCubeGrid = HashMap<Cube, Boolean>()
            currentCubeGrid.forEach { (cube, state) -> newCubeGrid[cube.copy()] = state}

            /*
            Iterate though every z layer + 1 the neighbours
             */
            for(z in this.startBounds.third.first-i..this.startBounds.third.last+i) {
                /*
                Iterate though every y layer + 1 the neighbours
                */
                for(y in this.startBounds.second.first-i..this.startBounds.second.last+i) {
                    /*
                    Iterate though every x layer + 1 the neighbours
                    */
                    for(x in this.startBounds.first.first-i..this.startBounds.first.last+i) {
                        val activeNeighbours = this.countActiveNeighbors(currentCubeGrid, x, y, z)
                        //first if not yet existing create
                        if(currentCubeGrid[Cube(x, y, z)] == null) {
                            currentCubeGrid[Cube(x, y, z)] = false
                        }
                        //Check conditions
                        if(currentCubeGrid[Cube(x, y, z)] == true && activeNeighbours !in 2..3) {
                            newCubeGrid[Cube(x, y, z)] = false
                        } else if(currentCubeGrid[Cube(x, y, z)] == false && activeNeighbours == 3) {
                            newCubeGrid[Cube(x, y, z)] = true
                        }
                    }
                }
            }

            currentCubeGrid = HashMap()
            newCubeGrid.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        }

        val activeCubes = currentCubeGrid.values.sumBy { state -> if(state) 1 else 0 }
        println("Active cubes after 6 simulation iterations: $activeCubes")
        return activeCubes
    }

    private fun countActiveNeighbors(cubes: HashMap<Cube, Boolean>, posX: Int, posY: Int, posZ: Int): Int {
        return directions.count { (dirX, dirY, dirZ) -> hasNeighbor(cubes, posX, posY, posZ, dirX, dirY, dirZ) }
    }

    private fun hasNeighbor(cubes: HashMap<Cube, Boolean>, posX: Int, posY: Int, posZ: Int, dirX: Int, dirY: Int, dirZ: Int): Boolean {
        return try {
            val neighbourState = cubes[Cube(posX + dirX, posY + dirY, posZ + dirZ)]
            neighbourState == true
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    data class Cube(val x: Int, val y: Int, val z: Int)
}