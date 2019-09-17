package Comando;

import Variavel.*;

public class ComandoEndfor extends Comando {
   
    int linhaFor;
    char variavel;
    String tipo;
		
    public ComandoEndfor(int lin, int linFor, char var, String tipo) {
        
        this.linha = lin;
        this.linhaFor = linFor;
        this.tipo = tipo;
        this.variavel = var;
        
    }
   
    @Override
    public int executa() {
        
        if(tipo.equals("to")){
            Variaveis.var[variavel - 'a']++;
        }
        else{
            Variaveis.var[variavel - 'a']--;
        }
        return linhaFor;
    }
}