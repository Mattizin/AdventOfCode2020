package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day14Test {

    @Test
    fun testPartI() {
        val day14 = Day14(File(Day14Test::class.java.getResource("/testinput_day_14.txt").file))
        Assertions.assertEquals(165.toBigInteger(), day14.solvePuzzlePartI())
    }

    @Test
    fun testPartII() {
        val day14 = Day14(File(Day14Test::class.java.getResource("/testinput_day_14_2.txt").file))
        Assertions.assertEquals(208.toBigInteger(), day14.solvePuzzlePartII())
    }
}