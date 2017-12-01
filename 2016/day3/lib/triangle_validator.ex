defmodule TriangleValidator do
  def get_valid_triangles(input) do
    input
    |> String.split("\n")
    |> Enum.reduce(0, &update_valid_count(&1, &2))
  end

  defp update_valid_count(line, count) do
    sides = line |> String.split(" ", trim: true) |> Enum.map(&String.to_integer(&1))
    if !Enum.empty?(sides) && triangle_valid?(sides) do
      count + 1
    else
      count
    end
  end

   # Triangles have 3 sides (duh), so we'll obviously assume that is the array
   # length
  defp triangle_valid?([a, b, c]) do
    (a + b > c) && (b + c > a) && (a + c > b)
  end
end
