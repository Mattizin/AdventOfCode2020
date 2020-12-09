package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day9Test {

    private val day9 = Day9(File(Day9Test::class.java.getResource("/testinput_day_9.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(127, day9.solvePuzzlePartI(5))
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(62, day9.solvePuzzlePartII(5))
    }
}