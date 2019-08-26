package Comando;

public class ComandoWriteStr extends Comando {

    String texto;

    public ComandoWriteStr(int lin, String txt) {
        linha = lin;
        texto = txt;
    }

    @Override
    public int executa() {
        System.out.print(texto);
        return linha + 1;
    }
}
