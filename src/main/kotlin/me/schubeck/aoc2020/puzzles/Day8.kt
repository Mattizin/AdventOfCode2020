package me.schubeck.aoc2020.puzzles

import java.io.File

class Day8(inputFile: File) {

    private val instructions = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 8")
        inputFile.forEachLine { instructions.add((it)) }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 8 Part 1")
        val accBeforeInfLoop = parseInstructions().first
        println("Accumulator value immediately before executing an instruction a second time entering an endless loop: $accBeforeInfLoop")
        return accBeforeInfLoop
    }

    fun solvePuzzlePartII() : Int {
        println("Day 8 Part 2")
        /*
        Brute Force each possible instruction change an check if execution finishes or enters infinite loop
         */
        var accAfterExecution = -1
        for(instructionIndex in 0 until instructions.size) {
            when(instructions[instructionIndex].substring(0, 3)) {
                //When jmp change to nop with same parameter. if test fails redo the change
                "jmp" -> {
                    instructions[instructionIndex] = "nop ${instructions[instructionIndex].substring(4)}"
                    val result = parseInstructions()
                    if(result.second) {
                        accAfterExecution = result.first
                        break;
                    } else {
                        instructions[instructionIndex] = "jmp ${instructions[instructionIndex].substring(4)}"
                    }
                }
                //When nop change to jmp with same parameter. if test fails redo the change
                "nop" -> {
                    instructions[instructionIndex] = "jmp ${instructions[instructionIndex].substring(4)}"
                    val result = parseInstructions()
                    if(result.second) {
                        accAfterExecution = result.first
                        break;
                    } else {
                        instructions[instructionIndex] = "nop ${instructions[instructionIndex].substring(4)}"
                    }
                }
            }
        }

        println("Accumulator value immediately after exiting the program successfully: $accAfterExecution")
        return accAfterExecution
    }

    private fun parseInstructions() : Pair<Int, Boolean> {
        var acc = 0
        val visitedInstructionIndices = ArrayList<Int>()
        var curInstructionIndex = 0
        while(curInstructionIndex !in visitedInstructionIndices) {
            val (curInstruction, paramString) = instructions[curInstructionIndex].split(" ")
            visitedInstructionIndices.add(curInstructionIndex)
            when(curInstruction) {
                "acc" -> {
                    acc += Integer.valueOf(paramString)
                    curInstructionIndex++
                }
                "jmp" -> curInstructionIndex += Integer.valueOf(paramString)
                "nop" -> curInstructionIndex++
            }

            if(curInstructionIndex >= instructions.size) {
                return Pair(acc, true)
            }
        }

        return Pair(acc, false)
    }
}