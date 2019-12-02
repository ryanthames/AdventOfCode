defmodule Day5Test do
  use ExUnit.Case
  doctest Day5

  test "should find the password given the door ID" do
    assert Day5.get_password("abc") == "18f47a30"
  end
end
