package unsymm;

public class NebenModul {

  /**
   * Berechnet ein Nebenmodul zu zwei gegebenen Primzahlen
   * phi(N) = (p-1)(q-1)
   * @param p Primzahl 1
   * @param q Primzahl 2
   * @return Nebenmdul
   */
  public static int getNebenmodul(int p, int q){
    return (p-1)*(q-1);
  }
}
