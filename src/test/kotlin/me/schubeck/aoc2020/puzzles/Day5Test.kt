package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day5Test {

    private val day5 = Day5(File(Day5Test::class.java.getResource("/testinput_day_5.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(820, day5.solvePuzzlePartI())
    }
}