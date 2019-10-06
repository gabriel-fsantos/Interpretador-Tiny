package Comando;

import Expressao.*;
import Variavel.Memoria;

public class ComandoAtrib extends Comando{

    char variavel;
    Expressao exp;

    public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao){
        this.variavel = var;
        this.exp = raizArvoreExpressao;
        linha = lin;
    }

    @Override
    public int executa(Memoria local, Memoria global){
        
        try {
            if(local.var[variavel - 97] != -1){
                local.var[variavel - 97] = exp.avalia(local, global);
            }
            else{
                global.var[variavel - 97] = exp.avalia(local, global);
            }  
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return linha + 1;
    }
}
