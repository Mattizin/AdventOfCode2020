package me.schubeck.aoc2020

import me.schubeck.aoc2020.puzzles.Day1
import me.schubeck.aoc2020.puzzles.Day2
import java.io.File

fun main() {
    println("Advent of Code 2020 Puzzles")
    var day1 = Day1(File(Day1::class.java.getResource("/input_day_1.txt").file));
    day1.solvePuzzlePart1()
    day1.solvePuzzlePart2()

    var day2 = Day2(File(Day1::class.java.getResource("/input_day_2.txt").file))
    day2.solvePuzzlePart1()
    day2.solvePuzzlePart2()
}
