import java.io.*;  
import java.util.*;

import lp.*;

class ComandoRead extends Comando {
   
   BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
   char variavel;
   	
   ComandoRead(int lin, String txt) {
      linha = lin;
      variavel = txt.charAt(0);
   }
   
   public int executa() {
       	
      try {
          Variaveis.var[variavel - 'a'] = Float.parseFloat(teclado.readLine());
      }
      catch( Exception e) {
         System.out.println("ERRO: "+e);
      }
      return linha+1;
   }
}