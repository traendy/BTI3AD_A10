package symm;

public class Verfahren {
  
  public void encrypt(String msg){
    int[] intClearArray= convertToInt(msg);
    int skey0 = SessionKeyGenerator.getSessionKey();
    int skey1 = SessionKeyGenerator.getSessionKey();
    int[] intKryptArray = new int[intClearArray.length+8];
    intKryptArray[0] = skey0;
    intKryptArray[1] = skey1;
    for(int i =0; i<intClearArray.length; i++){
      if(i%2==0){
        intKryptArray[i+8]=intClearArray[i]+skey1%95;
      }else {
        intKryptArray[i+8]=intClearArray[i]+skey0%95;
      }
      
    }
    
  }
  
  public void decrypt(int[] intKryptArray){
    
  }



  
  public int[] convertToInt(String str){
    int [] temp = new int[str.length()];
    int i =0;
    for(char c: str.toCharArray()){
      temp[i]=(int)c-32;
      i++;
    }
    return temp;
  }
}
