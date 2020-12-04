package me.schubeck.aoc2020.puzzles

import java.io.File

class Day4(inputFile: File) {
    private val rawPassports = ArrayList<String>()

    init {
        println("Advent of Code 2020 Day 4")
        //Read input and convert 1 password to 1 string
        var tmpLine = ""
        inputFile.forEachLine {
            when {
                it.isBlank() -> {
                    rawPassports.add(tmpLine)
                    tmpLine = ""
                }
                tmpLine.isEmpty() -> {
                    tmpLine = it
                }
                else -> {
                    tmpLine += " $it"
                }
            }
        }
        //Add Last passport line
        rawPassports.add(tmpLine)
    }

    fun solvePuzzlePart1() : Int {
        println("Day 4 Part 1")
        var validPassports = 0

        for(rawPassport in rawPassports) {
            val passport = HashMap<String, String>()
            for(pair in rawPassport.split(" ")) {
                val (key, value) = pair.split(":")
                passport[key] = value
            }
            when {isPassportValid(passport) -> validPassports++}
        }

        println("Valid passports: $validPassports")
        return validPassports
    }

    private fun isPassportValid(passport: HashMap<String, String>) : Boolean {
        return when {
            passport.keys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")) -> true
            else -> false
        }
    }
}