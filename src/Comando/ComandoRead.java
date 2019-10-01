package Comando;

import Variavel.Memoria;
import java.io.*;

public class ComandoRead extends Comando {

    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    char variavel;

    public ComandoRead(int lin, String txt) {
        linha = lin;
        variavel = txt.charAt(0);
    }

    @Override
    public int executa(Memoria local, Memoria global) {

        try {
            if(local.var[variavel - 97] != -1){
                local.var[variavel - 97] = Float.parseFloat(teclado.readLine());
            }
            else{
                global.var[variavel - 97] = Float.parseFloat(teclado.readLine());
            }       

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return linha + 1;
    }
}
