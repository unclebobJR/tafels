package entity;

public class Som {
  private int tafel;
  private int vermenigvuldiger;
  private char operator;

  public Som(int tafel, int vermenigvuldiger) {
    this.tafel = tafel;
    this.vermenigvuldiger = vermenigvuldiger;
    this.operator = 'x';
  }

  public void setOperator(char newOperator) {
    this.operator = newOperator;
  }

  public int antwoord() {
    switch(operator) {
      case 'x':
        return vermenigvuldiger * tafel;
      default:
        throw new Error("Operator niet toegestaan: " + operator);
    }
  }

  @Override
  public String toString() {
    return vermenigvuldiger + " x " + tafel;
  }

  @Override
  public boolean equals(Object other) {
    return (other instanceof Som) &&
            (((Som) other).tafel == this.tafel) &&
            (((Som) other).vermenigvuldiger == this.vermenigvuldiger) &&
            (((Som) other).operator == this.operator);
  }
}
