package Comando;

import Variavel.Memoria;

public abstract class Comando{
    
    protected int linha;

    public abstract int executa(Memoria local, Memoria global);
}