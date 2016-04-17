import mocks.MockConsole;
import mocks.MockPresenter;
import org.junit.Test;
import presenter.Presenter;
import view.Console;

import static org.junit.Assert.assertEquals;

public class OefeningTest {

  @Test
  public void tafelvan4() throws Exception {
    Console mockConsole = new MockConsole();
    Presenter presenter = new Presenter();
    presenter.setConsole(mockConsole);
    Oefening tafelvan4 = new Oefening();
    tafelvan4.setPresenter(presenter);
    tafelvan4.eenTafel(4);
    assertEquals(20, presenter.getHistory().size());
    int aantalGoed = 0;
    for (String outputRegel : presenter.getHistory()) {
      if (outputRegel.contains("Goed")) {
        aantalGoed++;
      }
    }
    assertEquals(10, aantalGoed);
  }

  @Test
  public void tafelvan4FoutAntwoord() throws Exception {
    Presenter presenter = new MockPresenter();
    Oefening tafelvan4 = new Oefening();
    tafelvan4.setPresenter(presenter);
    tafelvan4.eenTafel(4);
    int aantalFout = 0;
    for (String outputRegel : presenter.getHistory()) {
      if (outputRegel.contains("Fout")) {
        aantalFout++;
      }
    }
    assertEquals(10, aantalFout);
  }

}