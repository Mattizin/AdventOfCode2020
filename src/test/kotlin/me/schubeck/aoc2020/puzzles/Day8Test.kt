package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day8Test {
    private val day8 = Day8(File(Day8Test::class.java.getResource("/testinput_day_8.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(5, day8.solvePuzzlePartI())
    }
}