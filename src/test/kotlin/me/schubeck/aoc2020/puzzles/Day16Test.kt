package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day16Test {

    val day16 = Day16(File(Day16Test::class.java.getResource("/testinput_day_16.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(71, day16.solvePuzzlePartI())
    }
}