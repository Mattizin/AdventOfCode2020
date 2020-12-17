package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day17Test {

    private val day17 = Day17(File(Day17Test::class.java.getResource("/testinput_day_17.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(112, day17.solvePuzzlePartI())
    }

    @Test
    fun testPartII() {
        Assertions.assertEquals(848, day17.solvePuzzlePartII())
    }
}