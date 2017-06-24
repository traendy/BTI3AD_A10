package symm;

import static org.junit.Assert.*;

import org.junit.Test;

public class VerfahrenTest {

  @Test
  public void testConvertToInt() {
    Verfahren test = new Verfahren();
    int[] t = test.convertToInt("Alles ist rot");
    for(int i =0; i<t.length; i++){
      System.out.println(t[i]);
    }
    int[] abc = test.convertToInt("abc");
    for(int i =0; i<abc.length; i++){
      System.out.println(abc[i]);
    }
    int[] abcShould = {65,66,67};
    assertArrayEquals(abcShould, abc);
  }
  
  @Test
  public void testEncrypt(){
	
  }
  
  @Test 
  public void testDecrypt(){
	  
  }

}
