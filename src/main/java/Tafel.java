import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Tafel {
  private int tafel;
  private Set<Integer> vermenigvuldigers;


  Tafel(int tafel) {
    this.tafel = tafel;
    vermenigvuldigers = new HashSet<>(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
  }

  Som getNewSom(){
    if (vermenigvuldigers.size() == 0) {
      this.vermenigvuldigers = new HashSet<>(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
    }
    Random r = new Random();
    int willekeurigGetal = r.ints(1,1,11).findFirst().getAsInt();
    while (!vermenigvuldigers.contains(willekeurigGetal)) {
      willekeurigGetal = r.ints(1,1,11).findFirst().getAsInt();
    }
    vermenigvuldigers.remove(willekeurigGetal);
    return new Som(tafel, willekeurigGetal);
  }
}
