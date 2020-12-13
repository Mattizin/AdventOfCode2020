package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day13Test {

    private val day13 = Day13(File(Day13Test::class.java.getResource("/testinput_day_13.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(295, day13.solvePuzzlePartI())
    }
}