package aoc.year2019

import aoc.util.ListUtils
import java.lang.IllegalArgumentException

class IntcodeComputer(input: String) {
  val program: String

  init {
    val intList = ListUtils.convertCsvToIntList(input)

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

    program = ListUtils.convertIntListToCsv(intList)
  }
}