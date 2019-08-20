package Comando;

import java.io.*;  
import java.util.*;

import lp.*; 

public class ComandoWriteln extends Comando {
    
   public ComandoWriteln(int lin) {
      linha = lin;
   }
   
   public int executa() {
      System.out.println();
      return linha+1;
   }
}