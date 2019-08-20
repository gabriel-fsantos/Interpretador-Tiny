package Comando;
import Variavel.Variaveis;
import java.io.*;  
import java.util.*;

import lp.*;

public class ComandoRead extends Comando {
   
   BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
   char variavel;
   	
   public ComandoRead(int lin, String txt) {
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