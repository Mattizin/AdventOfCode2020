package me.schubeck.aoc2020.puzzles

import java.io.File

class Day6(inputFile: File) {

    private val inputFile: File;

    init {
        println("Advent of Code 2020 Day 6")
        this.inputFile = inputFile
    }

    fun solvePuzzlePartI() : Int {
        println("Day 6 Part 1")
        val distinctGroupAnswers =  ArrayList<String>()
        /*
        read all lines, combine group answers into one string, but only once for each answered question
         */
        var tmpLine = ""
        inputFile.forEachLine {
            when {
                it.isBlank() -> {
                    distinctGroupAnswers.add(tmpLine)
                    tmpLine = ""
                }
                tmpLine.isEmpty() -> {
                    tmpLine = it
                }
                else -> {
                    for(char in it) {
                        if(!tmpLine.contains(char)) {
                            tmpLine += char
                        }
                    }
                }
            }
        }
        //Add Last group line
        distinctGroupAnswers.add(tmpLine)

        /*
        Count individual answers and add the counts up
         */
        val solution = distinctGroupAnswers.map { s -> s.count() }.reduce { acc, i -> acc + i }
        println("Sum of yes answers: $solution")
        return solution
    }

    fun solvePuzzlePartII() : Int {
        println("Day 6 Part 2")
        val groups =  ArrayList<ArrayList<String>>()
        /*
        read all lines, combine all group answers into one group lsit objective
         */
        var group = ArrayList<String>()
        inputFile.forEachLine {
            when {
                it.isBlank() -> {
                    groups.add(group)
                    group = ArrayList<String>()
                }
                else -> {
                    group.add(it)
                }
            }
        }
        //Add Last group line
        groups.add(group)

        val groupsAllYes = ArrayList<Int>()
        for(group in groups) {
            val answersBase = group[0]
            var groupAllYes = answersBase.length
            group.remove(answersBase)

            for(char in answersBase) {
                for(answer in group) {
                    if (!answer.contains(char)) {
                        groupAllYes--
                        /*
                        Terminate looping through the answers for that char when one answer doesnt contain it and continue with next char
                         */
                        break;
                    }
                }
            }
            groupsAllYes.add(groupAllYes)
        }
//        println(groupsAllYes)
        val solution = groupsAllYes.reduce { acc, i ->  acc + i}
        println("Sum of yes answers by everyone in each group: $solution")
        return solution
    }
}