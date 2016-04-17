import entity.Som;
import entity.Tafel;
import presenter.Presenter;

class Oefening {

  private Presenter presenter;

  Oefening() {
    presenter = new Presenter();
  }

  void setPresenter(Presenter aPresenter) {
    this.presenter = aPresenter;
  }

  void eenTafel(int tafel) {
    Tafel deTafelVan = new Tafel(tafel);
    for (int i = 0; i < 10; i++) {
      Som opgave = deTafelVan.getNewSom();
      presenter.print(opgave.toString() + " = ");
      int gegevenAntwoord = presenter.getFilteredNumeriekInput();
      if (gegevenAntwoord == opgave.antwoord()) {
        presenter.println("Goed");
      } else {
        presenter.println("Fout");
      }
    }
  }

}
