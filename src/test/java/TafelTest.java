import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TafelTest {
  @Test
  public void testOfAlleMogelijkhedenPrecies1KeerGeraaktWorden() throws Exception {
    Tafel tafel = new Tafel(1);
    ArrayList<Som> alleMogelijkheden = new ArrayList<>(Arrays.asList(
            new Som(1, 1),
            new Som(1, 2),
            new Som(1, 3),
            new Som(1, 4),
            new Som(1, 5),
            new Som(1, 6),
            new Som(1, 7),
            new Som(1, 8),
            new Som(1, 9),
            new Som(1, 10)));
    while (alleMogelijkheden.size() > 0) {
      Som nieuweSom = tafel.getNewSom();
      boolean found = false;
      for (int i = 0;i < alleMogelijkheden.size(); i++) {
        if (alleMogelijkheden.get(i).equals(nieuweSom)) {
          alleMogelijkheden.remove(i);
          found = true;
          break;
        }
      }
      assertTrue(found);
    }
    assertTrue(alleMogelijkheden.size() == 0);
  }


}