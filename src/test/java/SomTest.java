import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class SomTest {

  @Test
  public void antwoord() throws Exception {
    assertTrue(new Som(1, 1).antwoord() == 1);
    assertTrue(new Som(1, 2).antwoord() == 2);
    assertTrue(new Som(2, 1).antwoord() == 2);
    assertTrue(new Som(2, 2).antwoord() == 4);
    assertTrue(new Som(2, 3).antwoord() == 6);

  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("3 x 2", new Som(2,3).toString());
  }

  @Test
  public void antwoordExceptionExpected() throws Exception {
    Som som = new Som(4,5);
    som.setOperator('+');
    boolean errorThrown = false;
    try {
      som.antwoord();
    } catch (Error error) {
      errorThrown = true;
      assertEquals("Operator niet toegestaan: +", error.getMessage());
    }
    assertTrue(errorThrown);
  }
}

