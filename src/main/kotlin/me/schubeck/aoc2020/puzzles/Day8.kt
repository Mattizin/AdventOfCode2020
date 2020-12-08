package me.schubeck.aoc2020.puzzles

import java.io.File
import javax.print.attribute.IntegerSyntax

class Day8(inputFile: File) {

    private val instructions = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 8")
        inputFile.forEachLine { instructions.add((it)) }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 8 Part 1")

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
        }

        println("Accumulator value immediately before executing an instruction a second time entering an endless loop: $acc")
        return acc
    }
}