package aoc.year2019

import junit.framework.Assert.assertEquals
import org.junit.Test

class Day02Test {
  @Test
  fun testPartOne() {
    assertEquals("2,0,0,0,99", Day02().buildIntcodeComputer("1,0,0,0,99"))
    assertEquals("2,3,0,6,99", Day02().buildIntcodeComputer("2,3,0,3,99"))
    assertEquals("2,4,4,5,99,9801", Day02().buildIntcodeComputer("2,4,4,5,99,0"))
    assertEquals("30,1,1,4,2,5,6,0,99", Day02().buildIntcodeComputer("1,1,1,4,99,5,6,0,99"))
  }
}