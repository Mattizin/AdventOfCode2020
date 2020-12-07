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
            parsedBags[bag] =  content.replace("[0-9]".toRegex(), "")
        }
    }

    fun solvePuzzlePartI() : Int {
        println("Day 7 Part 1")
        var solution = 0

        for(bag in parsedBags) {
            if(canContainMyBag(bag.value)) {
                solution++
            }
        }

        println("$solution bags are capable of holding my shiny gold bag")
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
            if(canContainMyBag(this.parsedBags[containedBag].orEmpty())) {
                return true
            }
        }
        return false
    }
}