package Expressao;

public class ExpComparativa extends Expressao {

    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE = 1;
    static final double FALSE = 0;

    public ExpComparativa(String op, Object exp1, Object exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.opr1 = (Expressao) exp1;
        this.opr2 = (Expressao) exp2;
    }

    @Override
    public double avalia() {
        
        boolean v = false;
        double valor = FALSE;
        
        switch(op){
            case(">"):
                v = this.opr2.avalia() > this.opr2.avalia();
                break;
            case("<"):
                v = this.opr2.avalia() < this.opr2.avalia();
                break;
            case(">="):
                v = this.opr2.avalia() >= this.opr2.avalia();
                break;
            case("<="):
                v = this.opr2.avalia() <= this.opr2.avalia();
                break;
            case("="):
                v = this.opr2.avalia() == this.opr2.avalia();
                break;
            case("<>"):
                v = this.opr2.avalia() != this.opr2.avalia();
                break;
        } 
        
        if (v == true) {
            valor = TRUE;
        }

        return valor;

    }
}
