package aoc.year2019

import org.junit.Assert.assertEquals
import org.junit.Test


class Day01Test {
  @Test
  fun testPartOne() {
    assertEquals(2, Day01().calculateFuelRequirements(12))
    assertEquals(2, Day01().calculateFuelRequirements(14))
    assertEquals(654, Day01().calculateFuelRequirements(1969))
    assertEquals(33583, Day01().calculateFuelRequirements(100756))
  }

  @Test
  fun testPartTwo() {
    assertEquals(2, Day01().calculateTotalFuelRequirements(12))
    assertEquals(966, Day01().calculateTotalFuelRequirements(1969))
    assertEquals(50346, Day01().calculateTotalFuelRequirements(100756))
  }
}