defmodule BathroomCodeCalculator do
  def calc_code(input) do
    input
    |> String.trim
    |> String.split("\n")
    |> Enum.reduce({5, ""}, &convert_line_to_code(&1, &2))
  end

  defp convert_line_to_code(line, {current_pos, code}) do
    resulting_pos = line
    |> String.graphemes
    |> Enum.reduce(current_pos, &process_action(&1, &2)) 

    {resulting_pos, code <> Integer.to_string(resulting_pos)}
  end

  defp process_action(action, current_pos) do
    # There's gotta be a cleaner way to do this...
    case action do
      "D" ->
        if(current_pos < 7) do
          current_pos + 3
        else
          current_pos
        end
      "U" ->
        if(current_pos > 3) do
          current_pos - 3
        else
          current_pos
        end
      "L" ->
        if(current_pos != 1 && current_pos != 4 && current_pos != 7) do
          current_pos - 1
        else
          current_pos
        end
      "R" ->
        if(current_pos != 3 && current_pos != 6 && current_pos != 9) do
          current_pos + 1
        else
          current_pos
        end
    end
  end
end
