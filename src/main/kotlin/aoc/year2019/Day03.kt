package aoc.year2019

import java.lang.Math.abs
import java.lang.RuntimeException

class Day03 : Day(3) {
  private fun List<Wire>.intersections(): Set<Pos> {
    return first().path.intersect(last().path)
  }

  override fun partOne(): Any {
    val wires = inputAsList
        .map { it.split(",") }
        .map { Wire().trace(it) }

    return wires.intersections()
        .map { it.distance }
        .min() ?: -1
  }

  override fun partTwo(): Any {
    val wires = inputAsList
        .map { it.split(",") }
        .map { Wire().trace(it) }


    return wires.intersections()
        .map { wires[0].distanceTo(it) + wires[1].distanceTo(it) }
        .min() ?: -1
  }

  data class Pos(val x: Int, val y: Int) {
    val distance: Int
      get() {
        return abs(x) + abs(y)
      }
  }

  data class Wire(val path: MutableList<Pos> = mutableListOf()) {
    fun trace(input: List<String>): Wire {
      var x = 0
      var y = 0

      input.forEach {
        val direction = it.first() // R
        val distance = it.drop(1).toInt() // 999
        val move: (Pos) -> Pos = when(direction) {
          'R' -> { (x, y) -> Pos(x + 1, y) }
          'U' -> { (x, y) -> Pos(x, y + 1) }
          'L' -> { (x, y) -> Pos(x - 1, y) }
          'D' -> { (x, y) -> Pos(x, y - 1) }
          else -> throw RuntimeException("Unknown direction $direction")
        }

        var lastPos = Pos(x, y)

        repeat(distance) {
          move(lastPos).let { currentPos ->
            path.add(currentPos)
            lastPos = currentPos
          }
        }

        x = lastPos.x
        y = lastPos.y
      }

      return this
    }

    fun distanceTo(pos: Pos): Int {
      return path.indexOf(pos) + 1
    }
  }
}