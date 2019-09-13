package Comando;

import Variavel.*;

public class ComandoEndfor extends Comando {
   
    int linhaFor;
    char variavel;
    String tipo;
		
    public ComandoEndfor(int lin, int linFor, char var, String tipo) {     
    }
   
    @Override
    public int executa() {	 
        return 0;
    }
}