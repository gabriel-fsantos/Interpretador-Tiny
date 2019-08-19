import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWriteln extends Comando {
   	
   ComandoWriteln(int lin) {
      linha= lin;
   }
   
   public int executa() {
      System.out.println("Isso devera ser retirado do programa. So inseri a string para voces verem que tem coisa sendo impressa.");
      return linha+1;
   }
}