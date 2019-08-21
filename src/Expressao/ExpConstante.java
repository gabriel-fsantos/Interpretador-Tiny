package Expressao;

public class ExpConstante extends Expressao {

    double valor;

    public ExpConstante(double valor) {
        this.valor = valor;
    }

    public double avalia() {
        return valor;
    }

}
