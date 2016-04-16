import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Console {

  private final ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
  private final PrintStream output = new PrintStream(byteArrayOutput);
  private InputStream input = System.in;

  Console() {
    System.setOut(output);
  }

  int getFilteredNumeriekInput(String text) {
    int filteredInput;
    output.print(text + " ");
    Scanner keyboardInput = new Scanner(input);
    String received = keyboardInput.next();
    Matcher eersteNumeriekeGetallen = Pattern.compile("(\\d+)").matcher(received);
    if (eersteNumeriekeGetallen.find()) {
      filteredInput = new Integer(eersteNumeriekeGetallen.group(0));
    } else {
      throw new Error("Kan hier geen numerieke waarde van maken: " + received);
    }
    return filteredInput;
  }

  void setInput(InputStream input) {
    this.input = input;
  }

  String getOutputString() {
    return byteArrayOutput.toString();
  }

  void println(String text) {
    output.println(text);
  }

}
