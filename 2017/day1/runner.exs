{:ok, input} = File.read("input.txt")
{:ok, input2} = File.read("input2.txt")
IO.puts(Day1.inverse_captcha(input))
IO.puts(Day1.inverse_captcha_halfway(input2))