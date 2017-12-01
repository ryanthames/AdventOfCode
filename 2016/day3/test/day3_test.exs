defmodule Day3Test do
  use ExUnit.Case
  doctest Day3

  test "should not count an invalid triangle" do
    input = "5  10  25"
    count = TriangleValidator.get_valid_triangles(input)
    assert count == 0
  end

  test "should count a valid triangle" do
    input = "12  13  15"
    count = TriangleValidator.get_valid_triangles(input)
    assert count == 1
  end
end
