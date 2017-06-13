package unsymm;

public class PublicKey {

  
  public static int getPublicKey(int nebenModul){
    
    int e=(int) (Math.random()*nebenModul+1);
    while(Euklid.ggt(nebenModul, e)!=1){
      e++;
    }
    return e;
    
  }
}
