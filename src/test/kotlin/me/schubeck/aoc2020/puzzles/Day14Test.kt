package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day14Test {

    private val day14 = Day14(File(Day14Test::class.java.getResource("/testinput_day_14.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(165, day14.solvePuzzlePartI())
    }
}