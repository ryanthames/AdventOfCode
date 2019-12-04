package aoc.util

import java.io.File

object InputReader {
  fun asIntList(day: Int): List<String> = getFile(day).readLines()
  fun asString(day: Int): String = getFile(day).readText()
  fun csvToList(day: Int): List<String> = getFile(day).readText().split(",")
  fun csvToIntList(day: Int): List<Int> = convertCsvToIntList(getFile(day).readText())

  private fun getFile(day: Int): File {
    return File("inputs/d${day}input.txt")
  }

  private fun convertCsvToIntList(csv: String) : MutableList<Int> {
    return csv.split(",").map { it.toInt() }.toMutableList()
  }
}