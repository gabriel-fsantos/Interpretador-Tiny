package Comando;

import Variavel.Variaveis;
import Expressao.*;

public class ComandoAtrib extends Comando {

    char variavel;
    Expressao exp;

    public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao) {
        this.variavel = var;
        this.exp = raizArvoreExpressao;
    }

    @Override
    public int executa() {
        try {
            Variaveis.var[variavel - 'a'] = exp.avalia();
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return linha + 1;
    }
}
