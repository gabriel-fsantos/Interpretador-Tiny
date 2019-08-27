package Comando;

import Expressao.*;

public class ComandoIf extends Comando implements Condicao {

    int linhaEnd;
    Expressao exp;

    public ComandoIf(int lin, Expressao raizArvoreExpressao) {
        linha = lin;
    }

    @Override
    public void setLinhaEnd(int lin) {
    }

    @Override
    public int executa() {
        return 0;
    }
}
