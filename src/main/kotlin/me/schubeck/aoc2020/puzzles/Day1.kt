package me.schubeck.aoc2020.puzzles

import java.io.File

class Day1 (private val inputFile: File){

    init {
        println("Advent of Code 2020 Day 1")
    }

    fun solvePuzzlePart1() : Int {
        println("Day 1 Part 1")
        var solution = -1
        val numbers = ArrayList<Int>()
        inputFile.forEachLine { numbers.add(Integer.valueOf(it)) }

        outerLoop@
        for(i in numbers) {
            val numbers2 = ArrayList<Int>(numbers);
            numbers2.remove(i);

            for(i2 in numbers2) {
                if(i + i2 == 2020) {
                    println("Numbers: $i and $i2")
                    solution = i*i2
                    println("Multiplication solution: $solution")
                    break@outerLoop
                }
            }
        }

        return solution;
    }

    fun solvePuzzlePart2() : Int {
        println("Day 1 Part 2")
        var solution = -1
        val numbers = ArrayList<Int>()
        inputFile.forEachLine { numbers.add(Integer.valueOf(it)) }

        outerLoop@
        for(i in numbers) {
            val numbers2 = ArrayList<Int>(numbers);
            numbers2.remove(i);

            for(i2 in numbers2) {
                val numbers3 = ArrayList<Int>(numbers2);
                numbers3.remove(i2);

                for(i3 in numbers3) {
                    if(i + i2 + i3 == 2020) {
                        println("Numbers: $i and $i2 and $i3")
                        solution = i*i2*i3
                        println("Multiplication solution: $solution")
                        break@outerLoop
                    }
                }
            }
        }

        return solution
    }
}