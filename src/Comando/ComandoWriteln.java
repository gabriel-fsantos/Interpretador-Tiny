package Comando;

public class ComandoWriteln extends Comando {

    public ComandoWriteln(int lin) {
        linha = lin;
    }

    @Override
    public int executa() {
        System.out.println();
        return linha + 1;
    }
}
