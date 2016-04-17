package view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Console {

  protected InputStream input = System.in;
  protected String output;

  public Console() {
  }

  public String getInput() {
    Scanner keyboardInput = new Scanner(input);
    return keyboardInput.next();
  }

  public void setInput(String t) {
    this.input = new ByteArrayInputStream(t.getBytes());
  }

  public String getOutput() {
    return this.output;
  }

  public void print(String s) {
    System.out.print(s);
  }

}
