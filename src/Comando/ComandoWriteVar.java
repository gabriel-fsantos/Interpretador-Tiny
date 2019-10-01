package Comando;

import Variavel.Memoria;

public class ComandoWriteVar extends Comando {

    char variavel;

    public ComandoWriteVar(int lin, String txt) {
        linha = lin;
        variavel = txt.charAt(0);
    }

    @Override
    public int executa(Memoria local, Memoria global) {
        if(local.var[variavel - 97] != -1){
            System.out.print(local.var[variavel - 97]);
        }
        else{
            System.out.print(global.var[variavel - 97]);
        }
        return linha + 1;
    }
}
