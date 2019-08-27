package Expressao;

public class ExpBinaria extends Expressao {

    String op;
    Object exp1, exp2;
    Expressao cmd1, cmd2;

    public ExpBinaria(String op, Object exp1, Object exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.cmd1 = (ExpConstante) exp1;
        this.cmd2 = (ExpConstante) exp2;    
    }
    
    @Override
    public double avalia() {
        
        double resultado = 0; 
        switch (op) {
            case "+":
                resultado = cmd2.avalia() + cmd1.avalia();
                break;
            case "-":
                resultado = cmd2.avalia() - cmd1.avalia();
                break;    
            case "*":
                resultado = cmd2.avalia() * cmd1.avalia();
                break;  
            case "/":
                resultado = cmd2.avalia() / cmd1.avalia();
                break; 
            default:
                break;
        }
        return resultado;
    }
}
