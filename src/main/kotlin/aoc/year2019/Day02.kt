package aoc.year2019

import aoc.util.ListUtils
import java.lang.IllegalArgumentException

class Day02 : Day(2) {
  override fun partOne(): Any {
    return ListUtils.convertCsvToIntList(buildIntcodeComputer(inputAsString))[0]
  }

  override fun partTwo(): Any {
    return findCorrectNounAndVerb(ListUtils.convertCsvToIntList(inputAsString))
  }

  @Throws(IllegalArgumentException::class)
  fun buildIntcodeComputer(input: String) : String {
    return IntcodeComputer(input).program
  }

  @Throws(IllegalArgumentException::class)
  private fun findCorrectNounAndVerb(input: List<Int>) : Int {
    val target = 19_690_720
    val upperBound = 100

    val mutableInput = input.toMutableList()

    (0 until upperBound).forEach { noun ->
      (0 until upperBound).forEach { verb ->
        mutableInput[1] = noun
        mutableInput[2] = verb

        val intcodeComputer = IntcodeComputer(ListUtils.convertIntListToCsv(mutableInput))
        val result = ListUtils.convertCsvToIntList(intcodeComputer.program)[0]

        if(target == result) {
          return 100 * noun + verb
        }
      }
    }

    throw IllegalArgumentException("Couldn't find a noun and verb combo to get $target")
  }
}