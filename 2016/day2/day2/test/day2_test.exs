defmodule Day2Test do
  use ExUnit.Case
  doctest Day2

  test "Should return the correct code for input" do
    input = 
      """
      ULL
      RRDDD
      LURDL
      UUUUD
      """

    {_, code} = BathroomCodeCalculator.calc_code(input)
    assert code == "1985"
  end
end
