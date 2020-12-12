package me.schubeck.aoc2020

import me.schubeck.aoc2020.puzzles.*
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
    day4.solvePuzzle()

    val day5 = Day5(File(Day5::class.java.getResource("/input_day_5.txt").file))
    day5.solvePuzzlePartI()
    day5.solvePuzzlePartII()

    val day6 = Day6(File(Day6::class.java.getResource("/input_day_6.txt").file))
    day6.solvePuzzlePartI()
    day6.solvePuzzlePartII()

    val day7 = Day7(File(Day7::class.java.getResource("/input_day_7.txt").file))
    day7.solvePuzzlePartI()
    day7.solvePuzzlePartII()

    val day8 = Day8(File(Day8::class.java.getResource("/input_day_8.txt").file))
    day8.solvePuzzlePartI()
    day8.solvePuzzlePartII()

    val day9 = Day9(File(Day9::class.java.getResource("/input_day_9.txt").file))
    day9.solvePuzzlePartI(25)
    day9.solvePuzzlePartII(25)

    val day10 = Day10(File(Day10::class.java.getResource("/input_day_10.txt").file))
    day10.solvePuzzlePartI()
    day10.solvePuzzlePartII()

    val day11 = Day11(File(Day11::class.java.getResource("/input_day_11.txt").file))
    day11.solvePuzzlePartI()
    day11.solvePuzzlePartII()

    val day12 = Day12(File(Day12::class.java.getResource("/input_day_12.txt").file))
    day12.solvePuzzlePartI()
}
