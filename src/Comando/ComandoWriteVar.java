package Comando;

import Variavel.Variaveis;

public class ComandoWriteVar extends Comando {

    char variavel;

    public ComandoWriteVar(int lin, String txt) {
        linha = lin;
        variavel = txt.charAt(0);
    }

    @Override
    public int executa() {
        System.out.print(Variaveis.var[variavel - 'a']);
        return linha + 1;
    }
}
