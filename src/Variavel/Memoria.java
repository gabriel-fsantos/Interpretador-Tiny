package Variavel;

public class Memoria{

    public double[] var;

    public Memoria(){
        
        var = new double[26];
        for (int i = 0; i < 26; i++){
            var[i] = -1;
        }
    }

    @Override
    public String toString(){
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            sb.append("[").append(i).append("] = ").append(var[i]).append("\n");
        }
        return sb.toString();
    }
}
