defmodule Day1Test do
  use ExUnit.Case
  doctest Day1

  test "should find the sum of digits that match the next digit" do
    assert Day1.inverse_captcha("1122") == 3
  end

  test "all digits matching" do
    assert Day1.inverse_captcha("1111") == 4
  end

  test "no digits match" do
    assert Day1.inverse_captcha("1234") == 0
  end

  test "circular list" do
    assert Day1.inverse_captcha("91212129") == 9
  end

  test "halfway match" do
    assert Day1.inverse_captcha_halfway("1212") == 6
    assert Day1.inverse_captcha_halfway("1221") == 0
    assert Day1.inverse_captcha_halfway("123425") == 4
    assert Day1.inverse_captcha_halfway("123123") == 12
    assert Day1.inverse_captcha_halfway("12131415") == 4
  end
end
