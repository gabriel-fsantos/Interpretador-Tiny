package Comando;

import Variavel.Memoria;

public abstract class Comando {
    
    protected int linha;

    public int executa(Memoria local, Memoria global) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}