package Comando;

import Variavel.Memoria;

public class ComandoWriteStr extends Comando{

    String texto;

    public ComandoWriteStr(int lin, String txt){
        linha = lin;
        texto = txt;
    }

    @Override
    public int executa(Memoria local, Memoria global){
        System.out.print(texto);
        return linha + 1;
    }
}
