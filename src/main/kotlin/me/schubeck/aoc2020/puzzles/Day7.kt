package me.schubeck.aoc2020.puzzles

import java.io.File

class Day7(inputFile: File) {

    private val parsedBags = HashMap<String, String>()

    init {
        println("Advent of Code 2020 Day 7")
        val bagDescriptions = ArrayList<String>()
        inputFile.forEachLine { bagDescriptions.add((it)) }
        for(bagDescription in bagDescriptions) {
            val (bag, content) = bagDescription
                    .replace(".", "")
                    .replace(" bags", " bag")
                    .replace(" bag", "")
                    .split(" contain ")

            if(content.contains("no other")) {continue}
            parsedBags[bag] =  content
        }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 7 Part 1")
        var solution = 0

        for(bag in parsedBags) {
            if(canContainMyBag(bag.value.replace("[0-9]".toRegex(), ""))) {
                solution++
            }
        }

        println("$solution bags are capable of holding my shiny gold bag")
        return solution
    }

    fun solvePuzzlePartII() : Int {
        println("Day 7 Part 2")
        val solution = calculateBagsInBag(this.parsedBags["shiny gold"].orEmpty())
        println("$solution bags are inside of on shiny bag")
        return solution
    }

    private fun canContainMyBag(bagDescription: String) : Boolean {
        if(bagDescription.isEmpty()) {
            return false
        }
        if(bagDescription.contains("shiny gold")) {
            return true
        }
        val containedBags = bagDescription.split(",").map { s -> s.trim() }
        for(containedBag in containedBags) {
            if(canContainMyBag(this.parsedBags[containedBag].orEmpty().replace("[0-9]".toRegex(), ""))) {
                return true
            }
        }
        return false
    }

    private fun calculateBagsInBag(bagDescription: String) : Int {
        if(bagDescription.isEmpty()) {
            return 0
        }

        var bagsInBag = 0
        val containedBags = bagDescription.split(",").map { s -> s.trim() }
        for(containedBag in containedBags) {
            val numBag = Integer.valueOf(containedBag.replace("[^0-9]".toRegex(), ""))
            bagsInBag += numBag + (numBag * calculateBagsInBag(this.parsedBags[containedBag.replace("[0-9]".toRegex(), "").trim()].orEmpty()))
        }

        return bagsInBag
    }
}