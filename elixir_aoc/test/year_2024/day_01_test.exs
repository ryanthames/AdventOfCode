defmodule AdventOfCode.Year2024.Day01Test do
  use ExUnit.Case, async: true

  import AdventOfCode.Year2024.Day01

  setup do
   [
     input: """
     3   4
     4   3
     2   5
     1   3
     3   9
     3   3
     """
   ]
  end

  test "parse", %{input: input} do
    assert [[3,4,2,1,3,3], [4,3,5,3,9,3]] == parse(input)
  end

  test "part1", %{input: input} do
    result = input |> parse() |> part1()
    assert result == 11
  end

  test "part2", %{input: input} do
    result = input |> parse() |> part2()
    assert result == 31
  end

  @tag :skip
  test "Day01RP1" do
    {:ok, contents} = File.read("test/year_2024/input/day_01_input.txt")
    result = contents |> parse() |> part1()
    IO.puts(result)

    assert result != nil
  end

  @tag :skip
  test "Day01RP2" do
    {:ok, contents} = File.read("test/year_2024/input/day_01_input.txt")
    result = contents |> parse() |> part2()
    IO.puts(result)

    assert result != nil
  end
end
