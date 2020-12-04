package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day4Test {

    private val day4 = Day4(File(Day3Test::class.java.getResource("/testinput_day_4.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(2, day4.solvePuzzlePart1())
    }
}