import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWriteStr extends Comando {
   
   String texto;
   	
   ComandoWriteStr(int lin, String txt) {
      linha= lin;
      texto= txt;
   }
   
   public int executa() {
      //Insira seu codigo
      return linha+1;
   }
}