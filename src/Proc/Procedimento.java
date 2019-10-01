package Proc;

import Variavel.*;
import Comando.*;
import java.util.*;

public class Procedimento {

    String nome;     			   // nome do procedimento  
    Vector comandos;    		   // vetor de comandos 
    String[] parametros;		   // parametros formais 
    String[] variaveisLocal;		   // variaveis local
    static Memoria global = new Memoria(); // variaveis globais	 

    public Procedimento(String n, String[] p) {
        nome = n;
        parametros = p;
    }

    public String getNome() {
        return nome;
    }

    public static void setVariaveisGlobal(String[] vG) {

        char var;
        for (String variavel : vG) {
            if (variavel != null){
                var = variavel.charAt(0);
                global.var[var - 'a'] = 0;
            }
        }
    }

    public void setVariaveisLocal(String[] vL) {
        this.variaveisLocal = vL;
    }

    public void setListaComandos(Vector c) {
        this.comandos = c;
    }

    public void executa(double[] argumentos) {

        Memoria local = new Memoria(); // variaveis local
        char var;

        // adiciona variaveis locais na memoria local
        if (variaveisLocal != null) {
            for(int i = 0; i < variaveisLocal.length; i++){
                if (variaveisLocal[i] != null){
                    local.var[variaveisLocal[i].charAt(0) - 'a'] = 0;
                }
            }
        }

        // associa argumentos a seus respectivos parametros formais 
        for(int i = 0; i < parametros.length; i++){
            if(parametros[i] != null){
                local.var[parametros[i].charAt(0) - 'a'] = argumentos[i];
            }
        }
        
        int pc = 0;
        do {
            pc = ((Comando) comandos.elementAt(pc)).executa(local, global);
        } while (pc < comandos.size());
    }
}
