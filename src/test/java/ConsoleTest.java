import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {

  @Test
  public void testFilteredNumeriekInput() throws Exception {
    Console console = new Console();
    console.setInput(new ByteArrayInputStream("5".getBytes()));
    assertEquals(5, console.getFilteredNumeriekInput("1 x 5 ="));
    assertEquals("1 x 5 = ", console.getOutputString());
    console.setInput(new ByteArrayInputStream("5a".getBytes()));
    assertEquals(5, console.getFilteredNumeriekInput(""));
    console.setInput(new ByteArrayInputStream("a5a".getBytes()));
    assertEquals(5, console.getFilteredNumeriekInput(""));
  }

  @Test
  public void testExpectedExceptionFilteredNumeriekInput() throws Exception {
    Console console = new Console();
    console.setInput(new ByteArrayInputStream("aa".getBytes()));
    boolean errorThrown = false;
    try {
      console.getFilteredNumeriekInput("");
    } catch (Error error) {
      errorThrown = true;
      assertEquals("Kan hier geen numerieke waarde van maken: aa", error.getMessage());
    }
    assertTrue(errorThrown);
  }
}