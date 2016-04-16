import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MockConsole extends Console {

  MockConsole() {
  }

  int getFilteredNumeriekInput(String text) {
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
