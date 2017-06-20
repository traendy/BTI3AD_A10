package hybrid;

import unsymm.PrimGenerator;
import unsymm.PrivateKey;
import unsymm.PublicKey;
import unsymm.RSAVerfahren;

public class Verfahren {

  
  
  public static void someMethod(){
    int nebenModul = RSAVerfahren.getNebenmodul(PrimGenerator.getPrim(),PrimGenerator.getPrim());
    int publicRSAKEY = PublicKey.getPublicKey(nebenModul);
    int privateRSAKey = PrivateKey.getPrivateKey(publicRSAKEY, nebenModul);
  
  }
}
