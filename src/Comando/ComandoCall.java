package Comando;

import Variavel.*;
import Expressao.*;
import Proc.*;

public class ComandoCall extends Comando {

    Procedimento procedimento;
    Expressao[] arg;
    int tamanho;

    public ComandoCall(int lin, Procedimento proc, Expressao[] a, int tam) {
        this.procedimento = proc;
        this.arg = a;
        this.tamanho = tam;
        this.linha = lin;
    }

    @Override
    public int executa(Memoria local, Memoria global) {

        double[] argumentos = new double[this.tamanho];
        int i = 0;

        while (this.arg[i] != null) {
            argumentos[i] = arg[i].avalia(local, global);
            i++;
        }

        this.procedimento.executa(argumentos);
        return linha + 1;
    }
}
