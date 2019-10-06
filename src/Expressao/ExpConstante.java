package Expressao;

import Variavel.Memoria;

public class ExpConstante extends Expressao{

    double valor;

    public ExpConstante(double valor){
        this.valor = valor;
    }

    @Override
    public double avalia(Memoria local, Memoria global){
        return valor;
    }
}
