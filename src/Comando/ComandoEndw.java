package Comando;

import Variavel.Memoria;

public class ComandoEndw extends Comando {

    int linhaW;

    public ComandoEndw(int lin, int linW) {
        this.linha = lin;
        this.linhaW = linW;
    }

    @Override
    public int executa(Memoria local, Memoria global) {
        return linhaW;
    }
}