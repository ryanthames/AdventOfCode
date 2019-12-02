package aoc.year2019

import aoc.util.InputReader

abstract class Day(day: Int) {
  protected val inputAsList: List<String> by lazy { InputReader.asList(day) }
  protected val inputAsString: String by lazy { InputReader.asString(day) }

  abstract fun partOne(): Any
  abstract fun partTwo(): Any
}