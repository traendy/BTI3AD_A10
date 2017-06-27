import java.util.Scanner;

import hybrid.HybridVerfahren;
import symm.BlockVerfahren;
import unsymm.RSAVerfahren;

public class Main {
  static boolean quit = false;
  
  
  public static void main(String[] args) {
  String publicKey= "";
  String msg = "";
  
  Scanner scanner = new Scanner(System.in);
  while(!quit){
    System.out.println("Wenn du eine Nachricht entschluesseln willst wähle 1 wenn du eine Nachricht verschlüsseln willst wähle 2. Zum beenden 3.");
    int tmp = Integer.valueOf(scanner.nextLine());
    if(tmp == 1 || tmp ==2){
      crypt(tmp);
    }else if(tmp==3){
      quit = true;
    }else{
      System.out.println("Falsche Eingabe! "+ tmp + " ist keine Möglichkeut ");
    }
  }
  
  }

  private static void crypt(int mode) { 
    int verfahren = 0;
    System.out.println("Welches Verfahren soll benutzt werden?");
    System.out.println("1. Symmetrisches Verfahren");
    System.out.println("2. Unsymmetrisches Verfahren");
    System.out.println("3. Hybrides Verfahren");
    System.out.println("4. Quit");
    Scanner scanner = new Scanner(System.in);
    verfahren = Integer.valueOf(scanner.nextLine());
    switch (verfahren){
      case 1:
        symm(mode);
        break;
      case 2:
        unsymm(mode);
        break;
      case 3:
        hybrid(mode);
        break;
      case 4:
        quit = true; 
        return;
      default:
        System.out.println("Falsche Eingabe!");
        crypt(mode);
    }
    
  }

  private static void hybrid(int mode) {
    Scanner scanner = new Scanner(System.in);
    String str= "";
    HybridVerfahren hybridVerfahren = new HybridVerfahren();
    if(mode== 1){
      System.out.println("Gib den Text ein den du entschlüsseln willst.");
      str = scanner.nextLine();
      System.out.println(hybridVerfahren.decrypt(str));
    }else{
      System.out.println("Gib den Text ein den du verschlüsseln willst.");
      str = scanner.nextLine();
       int pubKey = hybridVerfahren.getPublicKey();
      
      System.out.println(hybridVerfahren.encrypt(str, pubKey, hybridVerfahren.getRsaModul()));
      System.out.println("Publik Key ist: "+ pubKey);
    }
    
  }

  private static void unsymm(int mode) {
   Scanner scanner = new Scanner(System.in);
   String str = "";
   RSAVerfahren rsaVerfahren = new RSAVerfahren();
   rsaVerfahren.unsymmVerfahren();
   if(mode ==1){
     System.out.println("Gib den Text ein den du entschlüsseln willst.");
     str = scanner.nextLine();
     char [] tmp = str.toCharArray();
     int[] tmpint = new int[tmp.length];
     for(int i =0 ; i<tmp.length; i++){
       tmpint[i] = (int)tmp[i];
     }
     System.out.println(rsaVerfahren.decrypt(tmpint));
   }else{
     System.out.println("Gib den Text ein den du verschlüsseln willst.");
     str = scanner.nextLine();
     int pubKey = rsaVerfahren.getPublicKey();
     char [] tmp = str.toCharArray();
     int[] tmpint = new int[tmp.length];
     for(int i =0 ; i<tmp.length; i++){
       tmpint[i] = (int)tmp[i];
     }
     System.out.println(rsaVerfahren.encrypt(tmpint, pubKey, rsaVerfahren.getRsaModul()));
     System.out.println("Publik Key ist: "+ pubKey);
   }
   
 
  }

  private static void symm(int mode) {
    Scanner scanner = new Scanner(System.in);
    String str= "";
    BlockVerfahren blockVerfahren = new BlockVerfahren();
    if(mode== 1){
      System.out.println("Gib den Text ein den du entschlüsseln willst.");
      str = scanner.nextLine();
      System.out.println(blockVerfahren.decrypt2(str));
    }else{
      System.out.println("Gib den Text ein den du verschlüsseln willst.");
      str = scanner.nextLine();
   
      
      System.out.println(blockVerfahren.encrypt(str));
  
    }

  }


}
