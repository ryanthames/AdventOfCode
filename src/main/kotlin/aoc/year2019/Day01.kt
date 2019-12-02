package aoc.year2019

class Day01 : Day(1) {
  override fun partOne(): Any {
    return inputAsList.map { calculateFuelRequirements(it.toInt()) }.sum()
  }

  override fun partTwo(): Any {
    return inputAsList.map { calculateTotalFuelRequirements(it.toInt()) }.sum()
  }

  fun calculateFuelRequirements(mass: Int) : Int {
    return (mass / 3) - 2
  }

  fun calculateTotalFuelRequirements(mass: Int) : Int {
    val sum = calculateFuelRequirements(mass)

    return when {
      sum <= 0 -> 0
      else -> sum + calculateTotalFuelRequirements(sum)
    }
  }
}