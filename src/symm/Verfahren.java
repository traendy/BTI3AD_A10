package symm;

public class Verfahren {
  
  
  


  
  
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
