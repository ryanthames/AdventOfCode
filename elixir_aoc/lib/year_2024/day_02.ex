defmodule AdventOfCode.Year2024.Day02 do
  def parse(input) do
    input
    |> String.trim()
    |> String.split("\n")
    |> Enum.map(&String.split/1)
    |> Enum.map(fn line -> Enum.map(line, &String.to_integer/1) end)
  end

  def part1(input) do
    input
    |> Enum.each(fn list ->
      Enum.reduce(list, 0, fn x ->
        nil
      end)
    end)
  end

  def part2(input) do
  end
end
