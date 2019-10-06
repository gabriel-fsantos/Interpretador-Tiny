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

    public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao){
        
        this.linha = lin;
        this.varValor = Integer.parseInt(vValor);
        this.tipo = tipo;
        this.exp = raizArvoreExpressao;
        this.variavel = var.charAt(0);
        
    }

    public char getVar(){
        return variavel;
    }

    public String getTipo(){
        return tipo;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd = lin;
    }

    @Override
    public int executa(Memoria local, Memoria global){
        
        if(inicio){
            Variaveis.var[variavel-'a'] = varValor;
            inicio = !inicio;
        }
        
        if(tipo.equals("to")){
            if(Variaveis.var[variavel - 'a'] <= exp.avalia(local, global)){
                return linha+1;
            }
            else{
                inicio = true;
                return linhaEnd+1;
            }
        }
        else{
            if(Variaveis.var[variavel - 'a'] >= exp.avalia(local, global)){
                return linha+1;
            }
            else{
                inicio = true;
                return linhaEnd+1;
            }
        }
    }
}
