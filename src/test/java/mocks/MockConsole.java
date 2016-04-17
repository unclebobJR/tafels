package mocks;

import view.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MockConsole extends Console {

  public MockConsole() {
    output = "";
  }

  public String getInput() {
    if (output.isEmpty()) {
      return new BufferedReader(new InputStreamReader(input))
              .lines().collect(Collectors.joining("\n"));
    } else {
      String rightAnswer = getFilteredNumeriekInput(output).toString();
      print(rightAnswer);
      return rightAnswer;
    }
  }

  public void print(String text) {
    output = text;
  }

  private Integer getFilteredNumeriekInput(String text) {
    int tafel = -1;
    int vermenigvuldiger = -1;
    Matcher somMatch = Pattern.compile("(\\d+) x (\\d+) = ").matcher(text);
    if (somMatch.find()) {
      tafel = new Integer(somMatch.group(1));
      vermenigvuldiger = new Integer(somMatch.group(2));
    }
    return tafel * vermenigvuldiger;
  }

}
