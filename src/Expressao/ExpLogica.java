package Expressao;

import Variavel.Memoria;

public class ExpLogica extends Expressao{

    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE = 1;
    static final double FALSE = 0;

    public ExpLogica(String op, Object exp1, Object exp2){
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public double avalia(Memoria local, Memoria global){

        opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;
        
        boolean v = false,
        opr1B = this.opr1.avalia(local, global) == 1,
        opr2B = this.opr2.avalia(local, global) == 1;
        
        double valor = FALSE;
        
        switch(op){
            case("and"):
                v = opr2B && opr1B;
                break;
            case("or"):
                v = opr2B || opr1B;
                break;
            case("not"):
                v = !(opr2B);
                break;
        }
        
        if (v == true) {
            valor = TRUE;
        }
        return valor; 
    }
}
