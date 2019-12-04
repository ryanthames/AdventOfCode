package aoc.year2019

import java.lang.IllegalArgumentException

class Day02 : Day(2) {
  override fun partOne(): Any {
    return convertCsvToIntList(buildIntcodeComputer(inputAsString))[0]
  }

  override fun partTwo(): Any {
    return findCorrectNounAndVerb(convertCsvToIntList(inputAsString))
  }

  @Throws(IllegalArgumentException::class)
  fun buildIntcodeComputer(input: String) : String {
    val intList = convertCsvToIntList(input)

    var index = 0
    var opCode = intList[index]

    while(opCode != 99) {
      val xIndex = intList[index + 1]
      val yIndex = intList[index + 2]
      val replaceIndex = intList[index + 3]

      when(opCode) {
        1 -> intList[replaceIndex] = intList[xIndex] + intList[yIndex]
        2 -> intList[replaceIndex] = intList[xIndex] * intList[yIndex]
        else -> throw IllegalArgumentException("Unknown opCode $opCode")
      }

      index += 4
      opCode = intList[index]
    }

    return convertIntListToCsv(intList)
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

        val result = convertCsvToIntList(buildIntcodeComputer(convertIntListToCsv(mutableInput)))[0]

        if(target == result) {
          return 100 * noun + verb
        }
      }
    }

    throw IllegalArgumentException("Couldn't find a noun and verb combo to get $target")
  }

  private fun convertCsvToIntList(csv: String) : MutableList<Int> {
    return csv.split(",").map { it.toInt() }.toMutableList()
  }

  private fun convertIntListToCsv(input: List<Int>) : String {
    return input.joinToString(",")
  }
}