package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day6Test {

    private val day6 = Day6(File(Day6Test::class.java.getResource("/testinput_day_6.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(11, day6.solvePuzzlePartI())
    }
}