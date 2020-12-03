package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day3Test {

    private val day3 = Day3(File(Day3Test::class.java.getResource("/testinput_day_3.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(7, day3.solvePuzzlePart1())
    }
}