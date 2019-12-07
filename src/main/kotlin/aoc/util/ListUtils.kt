package aoc.util

object ListUtils {
  fun convertCsvToIntList(csv: String) : MutableList<Int> {
    return csv.split(",").map { it.toInt() }.toMutableList()
  }

  fun convertIntListToCsv(input: List<Int>) : String {
    return input.joinToString(",")
  }
}