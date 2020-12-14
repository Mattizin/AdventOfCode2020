package me.schubeck.aoc2020.puzzles

import java.io.File
import java.math.BigInteger
import kotlin.math.pow

class Day14(inputFile: File){

    private val rawInput = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 14")
        inputFile.forEachLine { this.rawInput.add((it)) }
    }

    fun solvePuzzlePartI() : BigInteger {
        println("Day 14 Part 1")

        val memory = HashMap<Int, BigInteger>()
        var currentMask = ""
        for(input in this.rawInput) {
            if(input.startsWith("mask")) {
                //parse current mask
                currentMask = input.substring(7)
            } else {
                //parse memory instruction, apply mask and save to memory index
                val memIndex = Integer.valueOf(input.substring(4,input.lastIndexOf(']')))
                val initialValue = this.toBinary(Integer.valueOf(input.substring(input.indexOf('=') + 2)), 36)
                var newValue = initialValue.toCharArray()
                for(i in currentMask.indices) {
                    if(currentMask[i] != 'X') {
                        newValue[i] = currentMask[i]
                    }
                }
                //BigInteger with Radix 2 parameter takes the String as Binary and outpouts as decimal, nice
                memory[memIndex] = BigInteger(String(newValue), 2)
            }
        }

        var solution : BigInteger = 0.toBigInteger()
        for (num in memory.filter { entry -> entry.value != 0.toBigInteger() }.values)  {
            solution += num
        }
        println("Solution: $solution")
        return solution
    }

    fun solvePuzzlePartII() : BigInteger {
        println("Day 14 Part 2")
        val memory = HashMap<BigInteger, Int>()
        var currentMask = ""

        for(input in this.rawInput) {
            if(input.startsWith("mask")) {
                //parse current mask
                currentMask = input.substring(7)
            } else {
                //parse memory instruction, apply mask and save to memory index
                val initialMemIndexBinary = this.toBinary(Integer.valueOf(input.substring(4,input.lastIndexOf(']'))), 36)
                val memValue = Integer.valueOf(input.substring(input.indexOf('=') + 2))
                var memIndexTemplate = initialMemIndexBinary.toCharArray()
                for(i in currentMask.indices) {
                    if(currentMask[i] != '0') {
                        memIndexTemplate[i] = currentMask[i]
                    }
                }
                for(i in this.getAllIndicesFromTemplate(String(memIndexTemplate))) {
                    memory[i] = memValue
                }
            }
        }

        var solution : BigInteger = 0.toBigInteger()
        for (num in memory.filter { entry -> entry.value != 0 }.values)  {
            solution += num.toBigInteger()
        }
        println("Solution: $solution")
        return solution
    }

    private fun toBinary(x: Int, len: Int): String {
        return String.format(
                "%" + len + "s",
                Integer.toBinaryString(x)
        ).replace(" ".toRegex(), "0")
    }

    private fun getAllIndicesFromTemplate(indexTemplate: String) : List<BigInteger> {
        val indices = ArrayList<BigInteger>()

        val indexX = indexTemplate.indexOf('X')
        if(indexX >= 0) {
            var newTemplate1 = indexTemplate.toCharArray()
            newTemplate1[indexX] = '0'
            indices.addAll(this.getAllIndicesFromTemplate(String(newTemplate1)))
            var newTemplate2 = indexTemplate.toCharArray()
            newTemplate2[indexX] = '1'
            indices.addAll(this.getAllIndicesFromTemplate(String(newTemplate2)))
        } else {
            indices.add(BigInteger(indexTemplate, 2))
        }

        return indices
    }
}