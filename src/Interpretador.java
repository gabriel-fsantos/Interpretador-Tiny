import Comando.*;
import Expressao.*;
import java.util.*;
import lp.*;

public class Interpretador {
    
    private ArquivoFonte arq;
    private Vector comandos;
    private Stack pilha;
    private String palavraAtual;
    private Expressao raizArvoreExpressao;

    public Interpretador(String nome) {
        arq = new ArquivoFonte(nome);
        comandos = new Vector();
    }

    public void listaArquivo() {
        String palavra;
        do {
            palavra = arq.proximaPalavra();
            System.out.println("Palavra: " + palavra);
        } while (!palavra.equals("EOF"));
    }

    public void leArquivo() {

        Stack pilhaC = new Stack();
        String comandoAtual;
        int linha = 0;
        pilhaC.push(linha);

        do {
            comandoAtual = arq.proximaPalavra();

            if (comandoAtual.equals("endp")){
                trataComandoEndp(linha);
                linha++;
            }
            else if (comandoAtual.equals("writeStr")){
                arq.proximaPalavra();
                comandoAtual = arq.proximaPalavra();       	
                trataComandoWriteStr(linha, comandoAtual);
                linha++;
            }
            else if (comandoAtual.equals("writeVar")){
                arq.proximaPalavra();
                comandoAtual = arq.proximaPalavra();
                trataComandoWriteVar(linha, comandoAtual);
                linha++;
            }
            else if (comandoAtual.equals("writeln")){
                trataComandoWriteln(linha);
                linha++;
            }
            else if (comandoAtual.equals("read")){
                arq.proximaPalavra();
                comandoAtual = arq.proximaPalavra();
                trataComandoRead(linha, comandoAtual);
                linha++;
            }
            else if (comandoAtual.equals("if")){
                pilhaC.push(linha);
                trataComandoIf(linha);
                linha++;					
            }
            else if (comandoAtual.equals("else")){
                int linhaIf = (Integer)pilhaC.pop();
                pilhaC.push(linha);
                trataComandoElse(linha, linhaIf);
                linha++;					
            }
            else if (comandoAtual.equals("endif")){
                int linhaIf = (Integer)pilhaC.pop();
                trataComandoEndif(linha, linhaIf);					
            }
            else if (comandoAtual.equals("while")){
                pilhaC.push(linha);
                trataComandoWhile(linha);
                linha++;				
            }
            else if (comandoAtual.equals("endw")){
                int linhaW = (Integer)pilhaC.pop();
                trataComandoEndw(linha, linhaW);
                linha++;				
            }
            else if (comandoAtual.equals("for")){
                pilhaC.push(linha);
                String variavel = arq.proximaPalavra();
                comandoAtual = arq.proximaPalavra();
                String varValor = arq.proximaPalavra();
                String tipo = arq.proximaPalavra();
                trataComandoFor(linha, variavel, varValor, tipo);
                linha++;				
            }
            else if (comandoAtual.equals("endfor")){
                int linhaFor = (Integer)pilhaC.pop();
                trataComandoEndfor(linha, linhaFor);
                linha++;				
            }
            else if ( comandoAtual.length() == 1 && comandoAtual.charAt(0) >= 'a' && comandoAtual.charAt(0) <= 'z'){
                String variavel = comandoAtual;
                comandoAtual = arq.proximaPalavra();
                trataComandoAtrib(linha, variavel);
                linha++;
            }
        } while (!comandoAtual.equals("endp"));
   }

    private void trataComandoEndp(int lin){

        ComandoEndp c = new ComandoEndp(lin);
        comandos.addElement(c);
    }

    private void trataComandoWriteStr(int lin, String txt){

        ComandoWriteStr c = new ComandoWriteStr(lin, txt);
        comandos.addElement(c);
    }

    private void trataComandoWriteVar(int lin, String txt){

        ComandoWriteVar c = new ComandoWriteVar(lin, txt);
        comandos.addElement(c);
    }

    private void trataComandoWriteln(int lin) {

        ComandoWriteln c = new ComandoWriteln(lin);
        comandos.addElement(c);
    }

    private void trataComandoRead(int lin, String txt){

        ComandoRead c = new ComandoRead(lin, txt);
        comandos.addElement(c);
    }

    private void trataComandoIf(int lin){
        
        trataExpressao();
        ComandoIf c = new ComandoIf(lin, raizArvoreExpressao);
        comandos.addElement(c);  
   }

    private void trataComandoElse(int lin, int linIf){
        
        ComandoIf cmd = (ComandoIf) comandos.elementAt(linIf);
        cmd.setLinhaEnd(lin+1);
        ComandoElse c = new ComandoElse(lin);
        comandos.addElement(c);  
    }

    private void trataComandoEndif(int lin, int linIfElse){
        
        Condicao cmd = (Condicao) comandos.elementAt(linIfElse);
        cmd.setLinhaEnd(lin); 
    }

    private void trataComandoWhile(int lin){
        
        trataExpressao();
        ComandoWhile c = new ComandoWhile(lin, raizArvoreExpressao);
        comandos.addElement(c);  
    }

    private void trataComandoEndw(int lin, int linW){
        
        ComandoWhile cmd = (ComandoWhile) comandos.elementAt(linW);
        cmd.setLinhaEnd(lin);
        ComandoEndw c = new ComandoEndw(lin, linW);
        comandos.addElement(c);  
    }
    
    private void trataComandoFor(int lin, String var, String varValor, String tipo){
        
        trataExpressao();
        ComandoFor c = new ComandoFor(lin, var, varValor, tipo, raizArvoreExpressao);
        comandos.addElement(c);  
    }

    private void trataComandoEndfor(int lin, int linFor){
        
        ComandoFor cmd = (ComandoFor) comandos.elementAt(linFor);
        cmd.setLinhaEnd(lin);
        ComandoEndfor c = new ComandoEndfor(lin, linFor, cmd.getVar() , cmd.getTipo());
        comandos.addElement(c);  
    }		

    private void trataComandoAtrib(int lin, String txt){
        
        char var= txt.charAt(0);
        trataExpressao();
        ComandoAtrib c= new ComandoAtrib(lin, var, raizArvoreExpressao);
        comandos.addElement(c);  
    }

    private void trataExpressao(){
        
        palavraAtual = arq.proximaPalavra();
        pilha = new Stack();
        expressaoLogica();
        raizArvoreExpressao = (Expressao) pilha.pop();
    }
    
    private void expressaoLogica(){
        
        expressaoComparativa();
        while (palavraAtual.equals("and") || palavraAtual.equals("or") || palavraAtual.equals("not")) {
            String op = palavraAtual;
            palavraAtual = arq.proximaPalavra();
            expressaoComparativa();
            Object exp1 = pilha.pop();
            Object exp2 = pilha.pop();
            pilha.push(new ExpLogica(op,exp1,exp2));
        }  
    }

    private void expressaoComparativa(){
    
        expressao();
        while(palavraAtual.equals("<") || palavraAtual.equals(">") || palavraAtual.equals(">=") ||
            palavraAtual.equals("<=") || palavraAtual.equals("<>") || palavraAtual.equals("=")) {
            String op = palavraAtual;
            palavraAtual = arq.proximaPalavra();
            expressao();
            Object exp1 = pilha.pop();
            Object exp2 = pilha.pop();
            pilha.push(new ExpComparativa(op,exp1,exp2));
        }  
    }

    private void expressao(){
        
        termo();
        while (palavraAtual.equals("+") || palavraAtual.equals("-")) {
            String op = palavraAtual;
            palavraAtual = arq.proximaPalavra();
            termo();
            Object exp1 = pilha.pop();
            if(pilha.empty()){
                pilha.push(new ExpConstante(0.0));
            }
            Object exp2 = pilha.pop();
            pilha.push(new ExpBinaria(op,exp1,exp2));
        }  
    }

    private void termo(){
        
        fator();
        while (palavraAtual.equals("*") || palavraAtual.equals("/")) {
            String op = palavraAtual;
            palavraAtual = arq.proximaPalavra();
            fator();
            Object exp1 = pilha.pop();
            Object exp2 = pilha.pop();
            pilha.push(new ExpBinaria(op,exp1,exp2));
        }  
    }

    private void fator() {
        
        if (palavraAtual.equals("sqrt")) {
            palavraAtual = arq.proximaPalavra();
            palavraAtual = arq.proximaPalavra();
            pilha.push(new ExpSqrt(palavraAtual));
            palavraAtual = arq.proximaPalavra();        
            palavraAtual = arq.proximaPalavra();
        }
        else if (palavraAtual.charAt(0) >= '0' && palavraAtual.charAt(0) <= '9') {
           pilha.push(new ExpConstante(Double.parseDouble(palavraAtual)));
           palavraAtual = arq.proximaPalavra();
        }
        else if (palavraAtual.charAt(0) >= 'a' && palavraAtual.charAt(0) <= 'z') {
            pilha.push(new ExpVariavel(palavraAtual.charAt(0)));
            palavraAtual = arq.proximaPalavra();
        } 
        else if (palavraAtual.equals("(")) {
            palavraAtual = arq.proximaPalavra();
            expressaoLogica();
            if (palavraAtual.equals(")")) {
                palavraAtual = arq.proximaPalavra();
            }         
        }    
    }

    public void executa() {

        Comando cmd;
        int pc = 0;
        do {
            cmd = (Comando) comandos.elementAt(pc);
            pc = cmd.executa();
        } while (pc != -1);
  }
}