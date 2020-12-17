package me.schubeck.aoc2020.puzzles

import java.io.File

class Day17(inputFile: File){

    /*
    Coordinates to all 26 neighbours of a point in a 3 dimensional (x, y, z) grid
     */
    private var directions3D = ArrayList<Triple<Int, Int, Int>>()
    /*
    Maps 3 dimensional cube objects to active true/false status
     */
    private val inputCubeGrid3D = HashMap<Cube3D, Boolean>()
    private val startBounds3D : Triple<IntRange, IntRange, IntRange>

    /*
    Coordinates to all 80 neighbours of a point in a 4 dimensional (x, y, z, w) grid
     */
    private var directions4D = ArrayList<Direction4D>()
    /*
    Maps 4 dimensional cube objects to active true/false status
     */
    private val inputCubeGrid4D = HashMap<Cube4D, Boolean>()
    private val startBounds4D : Bounds4D

    init {
        println("Advent of Code 2020 Day 17")
        var y = 0
        inputFile.forEachLine {
            for(x in it.indices) {
                this.inputCubeGrid3D[Cube3D(x, y, 0)] = (it[x] == '#')
                this.inputCubeGrid4D[Cube4D(x, y, 0, 0)] = (it[x] == '#')
            }
            y++
        }
        this.startBounds3D = Triple(inputFile.readLines()[0].indices, 0 until y, 0..0)
        this.startBounds4D = Bounds4D(inputFile.readLines()[0].indices, 0 until y, 0..0, 0..0)

        /*
        Generate 3D and 4D neighbour coordinates
         */
        for(x in -1..1) {
            for(y in -1..1) {
                for(z in -1..1) {
                    if(!(x==0&&y==0&&z==0)){
                        this.directions3D.add(Triple(x, y, z))
                    }
                    for(w in -1..1) {
                        if(x==0&&y==0&&z==0&&w==0) {
                            continue
                        }
                        this.directions4D.add(Direction4D(x, y, z, w))
                    }
                }
            }
        }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 17 Part 1")

        var currentCubeGrid = HashMap<Cube3D, Boolean>()
        this.inputCubeGrid3D.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        //Iterate 6 times
        for(i in 1..6)  {
            val newCubeGrid = HashMap<Cube3D, Boolean>()
            currentCubeGrid.forEach { (cube, state) -> newCubeGrid[cube.copy()] = state}

            /*
            Iterate though every z layer + 1 the neighbours
             */
            for(z in this.startBounds3D.third.first-i..this.startBounds3D.third.last+i) {
                /*
                Iterate though every y layer + 1 the neighbours
                */
                for(y in this.startBounds3D.second.first-i..this.startBounds3D.second.last+i) {
                    /*
                    Iterate though every x layer + 1 the neighbours
                    */
                    for(x in this.startBounds3D.first.first-i..this.startBounds3D.first.last+i) {
                        val activeNeighbours = this.countActiveNeighbors3D(currentCubeGrid, x, y, z)
                        //first if not yet existing create
                        if(currentCubeGrid[Cube3D(x, y, z)] == null) {
                            currentCubeGrid[Cube3D(x, y, z)] = false
                        }
                        //Check conditions
                        if(currentCubeGrid[Cube3D(x, y, z)] == true && activeNeighbours !in 2..3) {
                            newCubeGrid[Cube3D(x, y, z)] = false
                        } else if(currentCubeGrid[Cube3D(x, y, z)] == false && activeNeighbours == 3) {
                            newCubeGrid[Cube3D(x, y, z)] = true
                        }
                    }
                }
            }

            currentCubeGrid = HashMap()
            newCubeGrid.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        }

        val activeCubes = currentCubeGrid.values.sumBy { state -> if(state) 1 else 0 }
        println("Active cubes in 3D grid after 6 simulation iterations: $activeCubes")
        return activeCubes
    }

    fun solvePuzzlePartII() : Int {
        println("Day 17 Part 2")

        var currentCubeGrid = HashMap<Cube4D, Boolean>()
        this.inputCubeGrid4D.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        //Iterate 6 times
        for(i in 1..6) {
            val newCubeGrid = HashMap<Cube4D, Boolean>()
            currentCubeGrid.forEach { (cube, state) -> newCubeGrid[cube.copy()] = state}

            /*
            Iterate though every w layer + 1 the neighbours
             */
            for(w in this.startBounds4D.wBounds.first-i..this.startBounds4D.wBounds.last+i) {
                /*
                Iterate though every z layer + 1 the neighbours
                 */
                for(z in this.startBounds4D.zBounds.first-i..this.startBounds4D.zBounds.last+i) {
                    /*
                    Iterate though every y layer + 1 the neighbours
                    */
                    for(y in this.startBounds4D.yBounds.first-i..this.startBounds4D.yBounds.last+i) {
                        /*
                        Iterate though every x layer + 1 the neighbours
                        */
                        for(x in this.startBounds4D.xBounds.first-i..this.startBounds4D.xBounds.last+i) {
                            val activeNeighbours = this.countActiveNeighbors4D(currentCubeGrid, x, y, z, w)
                            //first if not yet existing create
                            if(currentCubeGrid[Cube4D(x, y, z, w)] == null) {
                                currentCubeGrid[Cube4D(x, y, z, w)] = false
                            }
                            //Check conditions
                            if(currentCubeGrid[Cube4D(x, y, z, w)] == true && activeNeighbours !in 2..3) {
                                newCubeGrid[Cube4D(x, y, z, w)] = false
                            } else if(currentCubeGrid[Cube4D(x, y, z, w)] == false && activeNeighbours == 3) {
                                newCubeGrid[Cube4D(x, y, z, w)] = true
                            }
                        }
                    }
                }
            }

            currentCubeGrid = HashMap()
            newCubeGrid.forEach { (cube, state) -> currentCubeGrid[cube.copy()] = state}
        }

        val activeCubes = currentCubeGrid.values.sumBy { state -> if(state) 1 else 0 }
        println("Active cubes in 4D grid after 6 simulation iterations: $activeCubes")
        return activeCubes
    }

    private fun countActiveNeighbors3D(cubes: HashMap<Cube3D, Boolean>, posX: Int, posY: Int, posZ: Int): Int {
        return directions3D.count { (dirX, dirY, dirZ) -> hasNeighbor3D(cubes, posX, posY, posZ, dirX, dirY, dirZ) }
    }

    private fun hasNeighbor3D(cubes: HashMap<Cube3D, Boolean>, posX: Int, posY: Int, posZ: Int, dirX: Int, dirY: Int, dirZ: Int): Boolean {
        return try {
            val neighbourState = cubes[Cube3D(posX + dirX, posY + dirY, posZ + dirZ)]
            neighbourState == true
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    private fun countActiveNeighbors4D(cubes: HashMap<Cube4D, Boolean>, posX: Int, posY: Int, posZ: Int, posW: Int): Int {
        return directions4D.count { (dirX, dirY, dirZ, dirW) -> hasNeighbor4D(cubes, posX, posY, posZ, posW, dirX, dirY, dirZ, dirW) }
    }

    private fun hasNeighbor4D(cubes: HashMap<Cube4D, Boolean>, posX: Int, posY: Int, posZ: Int, posW: Int, dirX: Int, dirY: Int, dirZ: Int, dirW: Int): Boolean {
        return try {
            val neighbourState = cubes[Cube4D(posX + dirX, posY + dirY, posZ + dirZ, posW + dirW)]
            neighbourState == true
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    data class Cube3D(val x: Int, val y: Int, val z: Int)
    data class Cube4D(val x: Int, val y: Int, val z: Int, val w: Int)
    data class Direction4D(val x: Int, val y: Int, val z: Int, val w: Int)
    data class Bounds4D(val xBounds: IntRange, val yBounds: IntRange, val zBounds: IntRange, val wBounds: IntRange)
}