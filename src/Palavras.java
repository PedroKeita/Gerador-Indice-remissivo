import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Palavras {
    private String palavra;
    private LinkedList<String> lista_palavra;


    HashMap<String, LinkedList<String>> mapa_palavra = new HashMap<>();


    public Palavras() {
        this.palavra = palavra;
    }

    public void divisaoPalavras(String linha, int numeroLinha, HashSet<String> palavras_chaves) {
        String[] palavras = linha.toLowerCase().replaceAll("[^a-zA-Z0-9 ]","").split("\\s+");

        for(String palavra : palavras) {
            if(!palavra.isEmpty() && palavras_chaves.contains(palavra)) {
                this.palavra = palavra;
                mapa_palavra.putIfAbsent(this.palavra, new LinkedList<>());

                LinkedList<String> lista_palavra = mapa_palavra.get(this.palavra);

                lista_palavra.add("Linha " + numeroLinha);
            }
        }
    }

    public HashMap<String, LinkedList<String>> getMapa_palavra() {
        return mapa_palavra;
    }

}
