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

    /*
    Part I and II are solved in one go here, because just the "Valid" Checks got more complex in part 2.
    Current implementation returns solution for Part II.
     */
    fun solvePuzzle() : Int {
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
        var valid = true;
        when {
            !passport.keys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))
                    || !passport["byr"]!!.all { Character.isDigit(it) }.and(Integer.valueOf(passport["byr"]) in 1920..2002)
                    || !passport["iyr"]!!.all { Character.isDigit(it) }.and(Integer.valueOf(passport["iyr"]) in 2010..2020)
                    || !passport["eyr"]!!.all { Character.isDigit(it) }.and(Integer.valueOf(passport["eyr"]) in 2020..2030)
                    || !validHeight(passport["hgt"].orEmpty())
                    || !Regex("#[a-f0-9]{6}").matches(passport["hcl"].orEmpty())
                    || passport["ecl"].orEmpty() !in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                    || !Regex("[0-9]{9}").matches(passport["pid"].orEmpty())
            -> valid = false
        }

        return valid
    }

    private fun validHeight(height: String) : Boolean {
        val (num, unit) = height.trim().let { Pair(it.substring(0, it.length-2), it.substring(it.length-2)) }
        val parsedNum = num.toIntOrNull() ?: return false
        return when(unit) {
            "cm" -> parsedNum in 150..193
            "in" -> parsedNum in 59..76
            else -> false
        }
    }
}