import org.junit.Test;

public class OefeningTest {
  @Test
  public void tafelvan4() throws Exception {
    Oefening tafelvan4 = new Oefening();
    Console mockConsole = new MockConsole();
    tafelvan4.setConsole(mockConsole);
    tafelvan4.eenTafel(4);
  }

}