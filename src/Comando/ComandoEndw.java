package Comando;

public class ComandoEndw extends Comando {

    int linhaW;

    public ComandoEndw(int lin, int linW) {
        this.linha = lin;
        this.linhaW = linW;
    }

    @Override
    public int executa() {
        return linhaW;
    }
}