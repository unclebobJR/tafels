import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Console {

  private InputStream input = System.in;
  private PrintStream output = System.out;

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

  public void setOutput(PrintStream output) {
    this.output = output;
  }

  public PrintStream getOutput() {
    return output;
  }
}
