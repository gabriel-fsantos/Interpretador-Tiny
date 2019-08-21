package Comando;

import Expressao.*;

public class ComandoIf extends Comando implements Condicao {

    int linhaEnd;
    Expressao exp;

    public ComandoIf(int lin, Expressao raizArvoreExpressao) {
    }

    public void setLinhaEnd(int lin) {
    }

    public int executa() {
        return 0;
    }
}
