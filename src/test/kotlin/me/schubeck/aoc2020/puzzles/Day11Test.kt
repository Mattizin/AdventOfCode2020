package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day11Test {

    private val day11 = Day11(File(Day11Test::class.java.getResource("/testinput_day_11.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(37, day11.solvePuzzlePartI())
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(26, day11.solvePuzzlePartII())
    }
}