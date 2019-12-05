package aoc.year2019

class Day04 : Day(4) {
  override fun partOne(): Any {
    return numPossiblePasswords()
  }

  override fun partTwo(): Any {
    return -1
  }

  private fun numPossiblePasswords() : Int {
    var result = 0

    (172930..683082).forEach { num ->
      var increments = true
      var dupes = false
      var repeatingDigitCount = 1
      var first = true

      var lastDigit = 0

      num.toString().toCharArray().forEach {
        // check for dupes
        if (first) {
          first = false
        } else {
          if (!dupes && it.toInt() == lastDigit) {
            repeatingDigitCount++
          } else {
            if (repeatingDigitCount == 2) {
              dupes = true
            }

            repeatingDigitCount = 1
          }
        }

        // check for increments only
        if (it.toInt() < lastDigit) {
          increments = false
        }

        lastDigit = it.toInt()
      }

      if (increments && (dupes || (repeatingDigitCount == 2 && !dupes))) {
        result++
      }
    }

    return result
  }
}