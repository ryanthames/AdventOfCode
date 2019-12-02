import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
  private static final String INPUT_FILENAME = "input/day2";
  public static void main(String... args) {
    // TODO: 12/2/18
    try {
      List<String> input = processInput();
      input.forEach(s -> {
        int s1 = s.length() - s.replace(".", "").length();
        System.out.println(s + " | " + s1);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static List<String> processInput() throws IOException {
    List<String> result = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME))) {
      String line;
      while((line = reader.readLine()) != null) {
        result.add(line.trim());
      }
    }

    return result;
  }
}
