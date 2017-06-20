package unsymm;

public class RSAVerfahren {
    
    int publicKey = 0;
    int privateKey =0;
    
  public void unsymmVerfahren(){
    int p = PrimGenerator.getPrim();
    int q = PrimGenerator.getPrim();
    int nebenModul = getNebenmodul(p, q); //phi(N)
    int hauptmodul = getHauptModul(p, q); //N = p*q
    //e ist entweder private  oder public key
    int e = PublicKey.getPublicKey(nebenModul);
    int d = PrivateKey.getPrivateKey(e, nebenModul);
    publicKey = e;
    privateKey = d;

  }
  
  /**
   * Auf welche art soll denn nun potenziert werden hier?
   * soll der String in ein int array umgebaut werden und dann jedes element
   * oder wie?
   * TODO
   * @param str
   * @return
   */
   public long genereiereZahlAusString(String str){
     return 0l;
   }

  /**
   * Berechnet das Nebenmodul
   * @param p primzahl 1
   * @param q primzahl 2
   * @return nebenmodul
   */
  public static int getNebenmodul(int p, int q){
    return (p-1)*(q-1);
  }
  
  /**
   * Berechnet das Hauptmodul aus zwei Primzahlen
   * N=p*q
   * @param p Primzahl 1
   * @param q Primzahl 2
   * @return Hauptmodul
   */
    public static int getHauptModul(int p, int q){
      return p*q;
    }
}
