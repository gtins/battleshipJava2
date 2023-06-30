import java.net.CookieHandler;
import java.util.HashMap;
import java.util.LinkedList;

public class Embarcacao {
    private String tipo;
    private HashMap<Integer,Cordenada> posicoes = new HashMap<>();
    private int forca;

    public Embarcacao(int x, int y, int tamanho , String tipo, boolean horizontal) {
        posicionar(x, y, tamanho, horizontal);
        this.forca = tamanho;
        this.tipo = tipo;
    }

    private void posicionar(int x, int y, int tamanho, boolean horizontal) {
        if(horizontal) {
            for (int i = 0; i < tamanho; i++) {
                Cordenada cordenada = new Cordenada(x + i, y);
                posicoes.put(cordenada.hashCode(), cordenada);
            }
        } else {
            for (int i = 0; i < tamanho; i++) {
                Cordenada cordenada = new Cordenada(x, y + i);
                posicoes.put(cordenada.hashCode(),cordenada);
            }
        }
    }

    @Override
    public String toString() {
        return tipo;
    }

    public String getPosicoes() {
        StringBuilder string = new StringBuilder();
        string.append(" (");
        for (Cordenada elemento: posicoes.values()
        ) {
            string.append(" x: ");
            string.append(elemento.getX());
            string.append(" y:");
            string.append(elemento.getY());
        }
        string.append(" )");
        return string.toString();
    }

    public int atirar(int x, int y) {
        boolean acertou =  acertou(x, y);
        if( acertou ) {
            diminuirForca();
        }
        return forca;
    }

    private void diminuirForca() {
        forca--;
    }

    public boolean acertou(int x, int y) {
        Cordenada tiro = new Cordenada(x, y);
        return posicoes.containsKey(tiro.hashCode());
    }

    public int getForca() {
        return this.forca;
    }
}
