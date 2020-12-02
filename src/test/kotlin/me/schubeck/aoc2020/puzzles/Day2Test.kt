package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day2Test {

    private val day2 = Day2(File(Day1::class.java.getResource("/testinput_day_2.txt").file))

    @Test
    fun testPart1() {
        Assertions.assertEquals(2, day2.solvePuzzlePart1())
    }
}