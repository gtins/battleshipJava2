import java.util.LinkedList;

public class Main {

    private static LinkedList<Embarcacao> embarcacoes;
    private static LinkedList<Cordenada> jogadas = new LinkedList<>();

    public static void main(String[] args) {
        embarcacoes = criar();
        mostrarNavios();
        jogadas();
        jogar();


    }

    private static void jogar() {
        for( Cordenada cordenada : jogadas) {
            atirar(cordenada);
            mostrarNavios();
        }
    }

    private static void jogadas() {
        jogadas.add( new Cordenada(1,1));
        jogadas.add( new Cordenada( 2, 1));
        jogadas.add( new Cordenada(6,3));
    }

    private static boolean atirar( Cordenada c ) {
        boolean acertou = false;
        int indice = 0;
        int forca = 0;
        do {
            Embarcacao elemento = embarcacoes.get(indice);
            if( elemento.acertou( c.getX(), c.getY()) ) {
                forca = elemento.atirar(c.getX(), c.getY());
                acertou = true;
            }
            indice++;
        } while( acertou != true && indice < embarcacoes.size());
        return acertou;
    }

    private static void mostrarNavios() {
        for (Embarcacao elemento: embarcacoes
             ) {
            System.out.println(elemento + " Forca " + elemento.getForca() + elemento.getPosicoes());
        }
    }

    private static LinkedList<Embarcacao> criar() {
        LinkedList<Embarcacao> embarcacoes = new LinkedList<>();
        embarcacoes.add( new Embarcacao(1,1,5, "N",true) );
        embarcacoes.add( new Embarcacao(2,1,5, "N",false) );
        embarcacoes.add( new Embarcacao(3,3,2, "s", true) );
        return embarcacoes;
    }
}