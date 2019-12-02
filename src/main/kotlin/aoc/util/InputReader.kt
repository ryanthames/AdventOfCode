package aoc.util

import java.io.File

object InputReader {
  fun asList(day: Int): List<String> = getFile(day).readLines()
  fun asString(day: Int): String = getFile(day).readText()

  private fun getFile(day: Int): File {
    return File("inputs/d${day}input.txt")
  }
}