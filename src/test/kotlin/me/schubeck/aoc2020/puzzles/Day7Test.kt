package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day7Test {

    private val day7 = Day7(File(Day7Test::class.java.getResource("/testinput_day_7.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(4, day7.solvePuzzlePartI())
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(32, day7.solvePuzzlePartII())
    }
}