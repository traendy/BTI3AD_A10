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
    
    
  }

}
