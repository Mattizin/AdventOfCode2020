package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day15Test {

    val day15 = Day15(File(Day15Test::class.java.getResource("/testinput_day_15.txt").file))

    @Test
    fun testPartI() {
        Assertions.assertEquals(436, day15.solvePuzzlePartI())
    }
}