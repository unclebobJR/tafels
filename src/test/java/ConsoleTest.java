import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {

  @Test
  public void testFilteredNumeriekInput() throws Exception {
    Console mockConsole = new MockConsole();
    mockConsole.setInput(new ByteArrayInputStream( "5".getBytes() ));
    assertEquals(5, mockConsole.getFilteredNumeriekInput("1 x 5 = "));
    assertEquals("1 x 5 = ", mockConsole.getOutput().toString());
    mockConsole.setInput(new ByteArrayInputStream( "5a".getBytes() ));
    assertEquals(5, mockConsole.getFilteredNumeriekInput(""));
    mockConsole.setInput(new ByteArrayInputStream( "a5a".getBytes() ));
    assertEquals(5, mockConsole.getFilteredNumeriekInput(""));
  }

  @Test
  public void testExpectedExceptionFilteredNumeriekInput() throws Exception {
    Console mockConsole = new Console();
    mockConsole.setInput(new ByteArrayInputStream("aa".getBytes()));
    boolean errorThrown = false;
    try {
      mockConsole.getFilteredNumeriekInput("");
    } catch (Error error) {
      errorThrown = true;
      assertEquals("Kan hier geen numerieke waarde van maken: aa", error.getMessage());
    }
    assertTrue(errorThrown);
  }
}