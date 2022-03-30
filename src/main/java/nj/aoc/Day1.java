package nj.aoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
  public static void main(String[] args) throws IOException {
    File inputFile = new File(Day1.class.getClassLoader().getResource("day1.txt").getFile());
    List<String> lst = Files.readAllLines(inputFile.toPath());
    List<Integer> input = lst.stream().map(Integer::parseInt).collect(Collectors.toList());
    Integer retValue = part1(input, 2020);
    System.out.println("Answer 1: " + retValue * (2020 - retValue));
    part2(input, 2020);
  }

  private static void part2(List<Integer> input, int limit) {
    for(int i = 0; i < input.size() - 2; i++) {
      Integer retValue = part1(input.subList(i+1, input.size()), limit - input.get(i));
      if(retValue != -1) {
        System.out.println("Answer 2: " + retValue * (limit - input.get(i) - retValue) * input.get(i));
      }
    }
  }

  private static Integer part1(List<Integer> lst, int limit) {
    Optional<Integer> first = lst.stream().filter(x -> lst.contains(limit-x)).findFirst();
    if(first.isPresent()) {
      return first.get();
    }
    return -1;
  }
}
