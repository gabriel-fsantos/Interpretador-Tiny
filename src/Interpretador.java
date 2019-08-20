import java.io.*;  
import java.util.*;

import lp.*; 

class Interpretador {
   private ArquivoFonte arq;
   private Vector comandos;   
   private String palavraAtual;
   		
   public Interpretador(String nome) {
      arq = new ArquivoFonte(nome);
      comandos = new Vector();
      Variaveis var = new Variaveis();
   }
   
   public void listaArquivo() {
      String palavra;
      
      do {
         palavra = arq.proximaPalavra();
         System.out.println ("Palavra: " + palavra);
      } while (!palavra.equals("EOF"));
   }
   
   public void leArquivo() {
      
      String comandoAtual;
      int linha = 0;
      do {
          
         comandoAtual= arq.proximaPalavra();
            
         if(comandoAtual.equals("endp")){
            trataComandoEndp(linha);
            linha++;
         }
         else if(comandoAtual.equals("writeln")){
            trataComandoWriteln(linha);
            linha++;
         }
         else if(comandoAtual.equals("writestr")){
            trataComandoWriteStr(linha);
            linha++; 
         }
         else if(comandoAtual.equals("read")){
             trataComandoRead(linha);
             linha++;
         }
                           		  
      } while (!comandoAtual.equals("endp"));
   }
   
   private void trataComandoEndp(int lin) {  
      ComandoEndp c = new ComandoEndp(lin);
      comandos.addElement(c);
   }
   	   	
   private void trataComandoWriteln(int lin) {   
      ComandoWriteln c = new ComandoWriteln(lin);
      comandos.addElement(c);
    }   	
   
    private void trataComandoWriteStr(int lin) {
      arq.proximaPalavra();
      ComandoWriteStr c = new ComandoWriteStr(lin, arq.proximaPalavra());
      comandos.addElement(c);
    }   
    
    private void trataComandoRead(int lin) {
        ComandoRead c = new ComandoRead(lin, arq.proximaPalavra());
        comandos.addElement(c);
    }
   
   public void executa() {
      
      Comando cmd;
      int pc = 0;
      do {
         cmd = (Comando) comandos.elementAt(pc);
         pc = cmd.executa();
      } while (pc != -1);
   }   

}
