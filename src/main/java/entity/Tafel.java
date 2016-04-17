package entity;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tafel {
  private int tafel;
  private Set<Integer> vermenigvuldigers;


  public Tafel(int tafel) {
    this.tafel = tafel;
    vermenigvuldigers = new HashSet<>(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
  }

  public Som getNewSom() {
    if (vermenigvuldigers.size() == 0) {
      this.vermenigvuldigers = new HashSet<>(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
    }
    int willekeurigGetal = -1;
    while (!vermenigvuldigers.contains(willekeurigGetal)) {
      willekeurigGetal = getWillekeurigGetal();
    }
    vermenigvuldigers.remove(willekeurigGetal);
    return new Som(tafel, willekeurigGetal);
  }

  private int getWillekeurigGetal() {
    Random r1 = new Random();
    OptionalInt o = r1.ints(1, 1, 11).findFirst();
    int willekeurigGetal = -1;
    if (o.isPresent()) {
      willekeurigGetal = o.getAsInt();
    }
    return willekeurigGetal;
  }
}
