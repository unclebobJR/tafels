import mocks.MockConsole;
import org.junit.Before;
import org.junit.Test;
import presenter.Presenter;
import view.Console;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PresenterTest {

  private Presenter presenter;
  private Console console;

  @Before
  public void setup() {
    console = new MockConsole();
    presenter = new Presenter();
    presenter.setConsole(console);
  }

  @Test
  public void print() throws Exception {
    presenter.print("test");
    assertEquals("test", console.getOutput());
  }

  @Test
  public void println() throws Exception {
    presenter.println("test");
    assertEquals("test" + "\n", console.getOutput());
  }

  @Test
  public void getHistory() throws Exception {
    presenter.print("1");
    presenter.print("2");
    assertEquals("1", presenter.getHistory().get(0));
    assertEquals("2", presenter.getHistory().get(1));
  }

  @Test
  public void testFilteredNumeriekInput() throws Exception {
    console.setInput("5");
    assertEquals(5, presenter.getFilteredNumeriekInput());
    console.setInput("5a");
    assertEquals(5, presenter.getFilteredNumeriekInput());
    console.setInput("a5a");
    assertEquals(5, presenter.getFilteredNumeriekInput());
  }

  @Test
  public void testExpectedExceptionFilteredNumeriekInput() throws Exception {
    console.setInput("aa");
    boolean errorThrown = false;
    try {
      presenter.getFilteredNumeriekInput();
    } catch (Error error) {
      errorThrown = true;
      assertEquals("Kan hier geen numerieke waarde van maken: aa", error.getMessage());
    }
    assertTrue(errorThrown);
  }


}