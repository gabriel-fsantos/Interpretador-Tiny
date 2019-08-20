import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWriteVar extends Comando {
   
   char variavel;
   	
   ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel= txt.charAt(0);
   }
   
   public int executa() {
      System.out.print(Variaveis.var[variavel - 'a']);
      return linha+1;
   }
}