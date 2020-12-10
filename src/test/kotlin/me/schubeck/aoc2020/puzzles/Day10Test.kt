package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day10Test {

    private val day10 = Day10(File(Day10Test::class.java.getResource("/testinput_day_10.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(220, day10.solvePuzzlePartI())
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(19208, day10.solvePuzzlePartII())
    }
}