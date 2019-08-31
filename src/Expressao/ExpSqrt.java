package Expressao;

public class ExpSqrt extends Expressao {

    String sqrt;

    public ExpSqrt(String sqrt) {
        this.sqrt = sqrt;
    }

    @Override
    public double avalia() {
        double valor;
        valor = Math.sqrt(Double.parseDouble(sqrt));
        return valor;
    }
}