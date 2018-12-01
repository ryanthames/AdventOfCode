defmodule Day2 do
  def run(file) do
    with {:ok, input} <- File.read(file),
         {:ok, lines} <- parse_input(input),
         {:ok, result} <- strip_empty_spaces(lines),
         {:ok, sums} <- sum_lines(result)
    do
      sums
      |> Enum.reduce(0, fn(x, acc) -> 
        {min, max} = x
        acc + (max - min)
      end)
    end
  end

  def run2(file) do
    with {:ok, input} <- File.read(file),
         {:ok, lines} <- parse_input(input),
         {:ok, result} <- strip_empty_spaces(lines),
         {:ok, sums} <- sum_lines_2(result)
    do
      IO.inspect(sums)
    end
  end

  defp sum_lines_2(lines) do
    lines
  end

  defp sum_lines(lines) do
    sums = Enum.map(lines, fn(x) -> Enum.map(x, &String.to_integer/1) end)
      |> Enum.map(fn(z) -> 
        Enum.reduce(z, {nil, nil}, fn(y, acc) -> 
          {min, max} = acc
          cond do
            min == nil -> {y, y} # first run
            y < min -> {y, max}
            y > max -> {min, y}
            true -> {min, max}
          end
        end)
      end)

    {:ok, sums}
  end

  defp strip_empty_spaces(lines) do
    {:ok, Enum.map(lines, fn(x) -> 
      # String.split(x, "\t")
      String.split(x, " ")
      |> Enum.filter(fn(y) -> y != "" end)
    end)}
  end

  defp parse_input(input) do
    {:ok, String.split(input, "\n")}
  end
end

System.argv |> hd() |> Day2.run() |> IO.puts
System.argv |> hd() |> Day2.run2() |> IO.puts