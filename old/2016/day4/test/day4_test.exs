defmodule Day4Test do
  use ExUnit.Case
  doctest Day4

  test "correctly determine the sum of sector IDs of real rooms" do
    input = [
      "aaaaa-bbb-z-y-x-123[abxyz]",
      "a-b-c-d-e-f-g-h-987[abcde]",
      "not-a-real-room-404[oarel]",
      "totally-real-room-200[decoy]"
    ]

    assert Day4.calculate_sum_of_sector_ids(input) == 1514
  end
end
