defmodule Day1 do
  def inverse_captcha(input) do
    int_list = convert_string_list_to_integer(input)
    
    {final_sum, _} = Enum.reduce(int_list, {0, List.last(int_list)}, fn(x, acc) -> 
      {sum, prev} = acc
      if x == prev do
        {sum + x, x}
      else 
        {sum, x}
      end
    end)

    final_sum
  end

  def inverse_captcha_halfway(input) do
    int_list = convert_string_list_to_integer(input)
    
    {final_sum, _, _, _} = Enum.reduce(int_list, {0, 0, int_list, Enum.at(int_list, get_halfway_from_index(0, length(int_list)))}, fn(x, acc) -> 
      {sum, current_index, int_list, comp} = acc
      new_comp = Enum.at(int_list, get_halfway_from_index(current_index + 1, length(int_list)))
      
      if x == comp do
        {sum + x, current_index + 1, int_list, new_comp}
      else 
        {sum, current_index + 1, int_list, new_comp}
      end
    end)

    final_sum
  end

  defp get_halfway_from_index(current_index, length) do
    new_index = current_index + (length / 2) |> round
    if new_index > (length-1) do
      new_index - length
    else
      new_index
    end
  end

  defp convert_string_list_to_integer(str_list) do
    str_list
    |> String.graphemes
    |> Enum.map(fn x -> String.to_integer(x) end)
  end
end
