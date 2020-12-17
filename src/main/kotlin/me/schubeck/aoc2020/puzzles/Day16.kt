package me.schubeck.aoc2020.puzzles

import java.io.File

class Day16(inputFile: File){
    /*
    Heavily inspired/taken from the great read at https://todd.ginsberg.com/post/advent-of-code/2020/day16/
    using many Kotlin specific features
     */

    private var ticketRules : Map<String,List<IntRange>>
    private var ourTicket: List<Int>
    private var nearbyTickets: List<List<Int>>

    init {
        println("Advent of Code 2020 Day 16")
        val input = ArrayList<String>()
        inputFile.forEachLine { input.add(it) }
        this.ticketRules = parseTicketRules(input)
        this.ourTicket = parseOurTicket(input)
        this.nearbyTickets = parseNearbyTickets(input)
    }

    fun solvePuzzlePartI() : Int {
        println("Day 16 Part 1")

        val allRuleRanges: List<IntRange> = this.ticketRules.values.flatten()
        val solution = this.nearbyTickets.sumBy { ticket ->
            ticket.filter { field ->
                allRuleRanges.none { rule -> field in rule }
            }.sum()
        }
        println("Sum of invalid ticket values: $solution")
        return solution
    }

    /*
    Parse the ticket rules into a map with the ticketRuleRegex below
    Key = Rule nam
    Value = List of IntRanges of valid numbers
     */
    private fun parseTicketRules(input: List<String>): Map<String,List<IntRange>> =
            input.takeWhile { it.isNotEmpty() }.map { line ->
                val (name, start1, end1, start2, end2) = ticketRuleRegex.matchEntire(line)!!.destructured
                name to listOf(
                        start1.toInt() .. end1.toInt(),
                        start2.toInt() .. end2.toInt()
                )
            }.toMap()

    /*
    Only parse the line below "your Ticket"
     */
    private fun parseOurTicket(input: List<String>): List<Int> =
            input.dropWhile { it != "your ticket:" }.drop(1).first().split(",").map { it.toInt() }

    /*
    Parse the lines below "nearby Tickets"
     */
    private fun parseNearbyTickets(input: List<String>): List<List<Int>> =
            input.dropWhile { it != "nearby tickets:" }.drop(1).map { row ->
                row.split(",").map { it.toInt() }
            }


    companion object {
        /*
        This regular expression creates five groups - one for the rule name and four for the two pair of ranges.
         */
        private val ticketRuleRegex = """^([a-z ]+): (\d+)-(\d+) or (\d+)-(\d+)$""".toRegex()
    }
}