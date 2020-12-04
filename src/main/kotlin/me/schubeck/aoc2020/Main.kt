package me.schubeck.aoc2020

import me.schubeck.aoc2020.puzzles.Day1
import me.schubeck.aoc2020.puzzles.Day2
import me.schubeck.aoc2020.puzzles.Day3
import me.schubeck.aoc2020.puzzles.Day4
import java.io.File

fun main() {
    println("Advent of Code 2020 Puzzles")
    val day1 = Day1(File(Day1::class.java.getResource("/input_day_1.txt").file));
    day1.solvePuzzlePart1()
    day1.solvePuzzlePart2()

    val day2 = Day2(File(Day2::class.java.getResource("/input_day_2.txt").file))
    day2.solvePuzzlePart1()
    day2.solvePuzzlePart2()

    val day3 = Day3(File(Day3::class.java.getResource("/input_day_3.txt").file))
    day3.solvePuzzlePart1()
    day3.solvePuzzlePart2()

    val day4 = Day4(File(Day4::class.java.getResource("/input_day_4.txt").file))
    day4.solvePuzzlePart1()
}
