{:ok, input} = File.read("input.txt")
IO.puts(TriangleValidator.get_valid_triangles(input))
