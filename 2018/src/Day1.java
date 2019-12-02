import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {
  private static final String INPUT_FILENAME = "input/day1";

  public static void main(String... args) {
    partOne();
    partTwo();
  }

  private static void partTwo() {
    try {
      Map<Integer, Integer> frequencyCount = new HashMap<>();
      Integer frequency = 0;
      System.out.println(findFirstDuplicateFrequency(processInput(), frequencyCount, frequency));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static Integer findFirstDuplicateFrequency(List<Integer> input, Map<Integer, Integer> frequencyCount, Integer frequency) {
    frequencyCount.put(frequency, 1);

    for(Integer i : input) {
      frequency += i;
      if(frequencyCount.containsKey(frequency)) {
        return frequency;
      } else {
        frequencyCount.put(frequency, 1);
      }
    }

    return findFirstDuplicateFrequency(input, frequencyCount, frequency);
  }

  private static void partOne() {
    try {
      List<Integer> input = processInput();
      Integer result = input.stream().reduce(0, (a, b) -> a + b);
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static List<Integer> processInput() throws IOException {
    List<Integer> intList = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME))) {
      String line;
      while((line = reader.readLine()) != null) {
        intList.add(Integer.parseInt(line.trim()));
      }
    }

    return intList;
  }
}
