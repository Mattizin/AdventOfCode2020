package me.schubeck.aoc2020.puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day1Test {

    private val day1 = Day1(File(Day1Test::class.java.getResource("/testinput_day_1.txt").file));

    @Test
    fun testPart1() {
        Assertions.assertEquals(514579, day1.solvePuzzlePart1())
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(241861950, day1.solvePuzzlePart2())
    }
}