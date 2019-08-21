package Comando;

import java.io.*;
import java.util.*;

import lp.*;

public class ComandoWriteStr extends Comando {

    String texto;

    public ComandoWriteStr(int lin, String txt) {
        linha = lin;
        texto = txt;
    }

    public int executa() {
        System.out.print(texto);
        return linha + 1;
    }
}
