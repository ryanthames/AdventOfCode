defmodule Day4 do
  def calculate_sum_of_sector_ids(input) do
    input
    |> Enum.reduce(0, fn(room, sum) -> sum + process_room(room) end)
  end

  defp process_room(room) do
    [sector_and_checksum|encrypted_name] = split_room(room)
    {sector, checksum} = split_sector_and_checksum(sector_and_checksum)

    case is_valid?(List.to_string(encrypted_name), checksum) do
      true -> sector
      false -> 0
    end
  end

  defp split_sector_and_checksum(sector_and_checksum) do
    [sector|[rest|_]] = sector_and_checksum |> String.split("[")
     checksum = String.replace(rest, "]", "")
    {String.to_integer(sector), checksum}
  end

  defp split_room(room) do
    room
    |> String.split("-")
    |> Enum.reverse
  end

  defp is_valid?(encrypted_name, checksum) do
    letter_map = construct_letter_map(encrypted_name)

    expected_checksum = construct_expected_checksum(letter_map, []) 
                        |> Enum.slice(0..4)
                        |> List.to_string

    expected_checksum == checksum
  end

  defp construct_letter_map(encrypted_name) do
    encrypted_name
    |> String.graphemes
    |> Enum.reduce(%{}, fn(letter, acc) -> Map.update(acc, letter, 1, &(&1+1)) end)
    |> Enum.reduce(%{}, fn({letter, occ}, acc) -> 
      Map.update(acc, occ, [letter], &(&1 ++ [letter])) end)
    |> Enum.sort
    |> Enum.reverse
  end

  defp construct_expected_checksum([{_occ, letters} | rest], result) do
    result = letters
             |> Enum.sort
             |> Enum.reduce(result, fn(letter, acc) -> acc ++ [letter] end)

    construct_expected_checksum(rest, result)
  end

  defp construct_expected_checksum([], result), do: result
end
