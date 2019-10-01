package Comando;

import Expressao.*;
import Variavel.Memoria;
	 
public class ComandoWhile extends Comando{

    int linhaEnd;
    Expressao exp;

    public ComandoWhile(int lin, Expressao raizArvoreExpressao) {
        this.exp = raizArvoreExpressao;
        this.linha = lin;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd = lin;
    }

    @Override
    public int executa(Memoria local, Memoria global) {
        if(exp.avalia(local, global) == 1){
            return linha + 1;
        }
        return linhaEnd + 1;
    }
}

