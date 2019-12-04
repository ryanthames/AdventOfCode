package aoc.year2019

import aoc.util.InputReader

abstract class Day(day: Int) {
  protected val inputAsList: List<String> by lazy { InputReader.asIntList(day) }
  protected val inputAsString: String by lazy { InputReader.asString(day) }
  protected val csvInputAsList: List<String> by lazy { InputReader.csvToList(day) }

  abstract fun partOne(): Any
  abstract fun partTwo(): Any
}