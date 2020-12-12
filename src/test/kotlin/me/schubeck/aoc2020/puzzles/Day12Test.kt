package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day12Test {

    private val day12 = Day12(File(Day12Test::class.java.getResource("/testinput_day_12.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(25, day12.solvePuzzlePartI())
    }

    @Test
    fun testPartII() {
        Assertions.assertEquals(286, day12.solvePuzzlePartII())
    }
}