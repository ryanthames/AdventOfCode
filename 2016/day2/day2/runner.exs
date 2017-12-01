{:ok, input} = File.read("input.txt")
{_, code} = BathroomCodeCalculator.calc_code(input)
IO.puts(code)
