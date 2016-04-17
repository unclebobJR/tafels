package presenter;

import view.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Presenter {

  private Console console;
  private List<String> history;

  public Presenter() {
    console = new Console();
    history = new ArrayList<>();
  }

  public void setConsole(Console aConsole) {
    this.console = aConsole;
  }

  public int getFilteredNumeriekInput() {
    int filteredInput;
    String received = console.getInput();
    Matcher eersteNumeriekeGetallen = Pattern.compile("(\\d+)").matcher(received);
    if (eersteNumeriekeGetallen.find()) {
      filteredInput = new Integer(eersteNumeriekeGetallen.group(0));
    } else {
      throw new Error("Kan hier geen numerieke waarde van maken: " + received);
    }
    return filteredInput;
  }

  public void print(String s) {
    console.print(s);
    history.add(s);
  }

  public void println(String s) {
    s = s + "\n";
    print(s);
  }

  public List<String> getHistory() {
    return history;
  }
}
