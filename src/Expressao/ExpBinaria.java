package Expressao;

public class ExpBinaria extends Expressao {

    String op;
    Object exp1, exp2;
    Expressao cmd1, cmd2;

    public ExpBinaria(String op, Object exp1, Object exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public double avalia() {
        
        double resultado = 0; 
        switch (op) {
            case "+":
                resultado = (double) exp1 + (double) exp2;
                break;
            case "-":
                resultado = (double) exp1 - (double) exp2;
                break;    
            case "*":
                resultado = (double) exp1 * (double) exp2;
                break;  
            case "/":
                resultado = (double) exp1 / (double) exp2;
                break; 
            default:
                break;
        }
        return resultado;
    }
}
