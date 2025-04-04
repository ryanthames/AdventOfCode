defmodule AdventOfCode.Year2024.Day01 do

  def parse(input) do
    input
    |> String.trim()
    |> String.split("\n")
    |> Enum.map(fn line ->
      [a,b] = String.split(line) |> Enum.map(&String.to_integer/1)
      {a,b}
    end)
    |> Enum.unzip()
    |> then(fn {a_list, b_list} -> [a_list,b_list] end)
  end

  def part1(input), do: solve(input)

  defp solve(input) do
    input
    |> Enum.map(&Enum.sort/1)
    |> then(fn [list1, list2] -> Enum.zip_with(list1, list2, fn x, y -> abs(x - y) end) end)
    |> Enum.sum
  end

  def part2(input) do
    [list1, list2] = input

    list1
    |> Enum.map(fn x -> x * Enum.count(list2, fn y -> y == x end) end)
    |> Enum.sum
  end
end
