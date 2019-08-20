import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWriteStr extends Comando {
   
   String texto;
   	
   ComandoWriteStr(int lin, String txt) {
      linha = lin;
      texto = txt;
   }
   
   public int executa() {
      System.out.print(texto);
      return linha+1;
   }
}