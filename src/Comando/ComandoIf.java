package Comando;

import Expressao.*;

public class ComandoIf extends Comando implements Condicao {

    int linhaEnd;
    Expressao exp;

    public ComandoIf(int lin, Expressao raizArvoreExpressao) {
        this.linha = lin;
        this.exp = raizArvoreExpressao;
    }

    @Override
    public void setLinhaEnd(int lin) {
        linhaEnd = lin;
    }

    @Override
    public int executa() {
         if(exp.avalia() == 1){
             return linha + 1;
         }
         return linhaEnd;
    }
}
