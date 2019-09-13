package Comando;

import Variavel.*;
import Expressao.*;

public class ComandoFor extends Comando{

    int linhaEnd;
    int varValor;
    double limite;
    char variavel;
    String tipo;
    Expressao exp;
    boolean inicio = true;

    public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao) {
    }

    public char getVar(){
        return variavel;
    }

    public String getTipo(){
        return tipo;
    }

    public void setLinhaEnd(int lin){
    }

    @Override
    public int executa() {
        return 0;
    }
}

