package Comando;

public class ComandoElse extends Comando implements Condicao {

    int linhaEnd;

    public ComandoElse(int lin) {
        this.linha = lin;
    }

    @Override
    public void setLinhaEnd(int lin) {
        this.linhaEnd = lin;
    }

    @Override
    public int executa() {
        return linhaEnd;
    }
}
