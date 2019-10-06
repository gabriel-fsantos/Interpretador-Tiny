package Expressao;

import Variavel.Memoria;

public class ExpBinaria extends Expressao{

    String op;
    Object exp1, exp2;
    Expressao cmd1, cmd2;

    public ExpBinaria(String op, Object exp1, Object exp2){
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.cmd1 = (Expressao) exp1;
        this.cmd2 = (Expressao) exp2;    
    }
    
    @Override
    public double avalia(Memoria local, Memoria global){
        
        double resultado = 0; 
        switch (op) {
            case "+":
                resultado = cmd2.avalia(local, global) + cmd1.avalia(local, global);
                break;
            case "-":
                resultado = cmd2.avalia(local, global) - cmd1.avalia(local, global);
                break;    
            case "*":
                resultado = cmd2.avalia(local, global) * cmd1.avalia(local, global);
                break;  
            case "/":
                resultado = cmd2.avalia(local, global) / cmd1.avalia(local, global);
                break; 
            default:
                break;
        }
        return resultado;
    }
}