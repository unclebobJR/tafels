class Oefening {

  private Console console = new Console();

  void eenTafel(int tafel) {
    Tafel deTafelVan = new Tafel(tafel);
    for (int i = 0; i < 10; i++) {
      Som opgave = deTafelVan.getNewSom();
      int gegevenAntwoord = console.getFilteredNumeriekInput(opgave.toString() + " = ");
      if (gegevenAntwoord == opgave.antwoord()) {
        console.println("Goed");
      } else {
        console.println("Fout");
      }
    }
  }

  void setConsole(Console console) {
    this.console = console;
  }
}
