defmodule Directions do
  def calculate_blocks(input) do
    input
    |> String.split(", ")
    |> Enum.reduce({:north, 0, 0}, &process_instruction(&1, &2))
    |> diff_x_y
  end

  defp diff_x_y({_, x, y}) do
    abs(abs(x) + abs(y))
  end

  defp process_instruction(inst, status) do
    inst
    |> convert_inst_to_correct_format
    |> update_status(status)
  end

  defp convert_inst_to_correct_format(inst) do
    {dir, steps} = String.split_at(inst, 1)
    {String.to_atom(dir), String.to_integer(steps)}
  end

  defp update_status(inst, {:north, x, y}) do
    case inst do
      {:L, steps} -> {:west, x - steps, y}
      {:R, steps} -> {:east, x + steps, y}
    end
  end

  defp update_status(inst, {:south, x, y}) do
    case inst do
      {:L, steps} -> {:east, x + steps, y}
      {:R, steps} -> {:west, x - steps, y}
    end
  end

  defp update_status(inst, {:west, x, y}) do
    case inst do
      {:L, steps} -> {:south, x, y - steps}
      {:R, steps} -> {:north, x, y + steps}
    end
  end

  defp update_status(inst, {:east, x, y}) do
    case inst do
      {:L, steps} -> {:north, x, y + steps}
      {:R, steps} -> {:south, x, y - steps}
    end
  end
end

{:ok, input} = File.read("input.txt")
input = String.trim(input)
IO.puts(Directions.calculate_blocks(input))


