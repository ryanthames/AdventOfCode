package aoc.util

import aoc.year2019.Day
import org.reflections.Reflections

object DayRunner {
  private val reflections = Reflections("aoc.year2019")

  @JvmStatic
  fun main(args: Array<String>) = when {
    args.isNotEmpty() -> runDay(args)
    else -> runDays()
  }

  private fun runDays() {
    val ds = allDays()
    when {
      ds != null -> ds.forEach { printDay(it) }
      else -> System.err.println("Days not found")
    }
  }

  private fun runDay(args: Array<String>) {
    val dayToRun = args[0].toInt()

    val day = allDays()?.find { it.simpleName.endsWith(dayToRun.toString().padStart(2, '0')) }
    when {
      day != null -> printDay(day)
      else -> System.err.println("Day $dayToRun not found")
    }
  }

  private fun allDays(): MutableSet<Class<out Day>>? {
    return reflections.getSubTypesOf(Day::class.java)
  }

  private fun printDay(dayClass: Class<out Day>) {
    val day = dayClass.constructors[0].newInstance() as Day
    println("Part 1: ${day.partOne()}")
    println("Part 2: ${day.partTwo()}")
  }
}