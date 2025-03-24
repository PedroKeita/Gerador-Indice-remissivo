package buffers;

import palavra.Palavras;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.TreeMap;

public class BufferedWriter_Saida {
    String saida;
    Palavras palavrasformatadas;

    public BufferedWriter_Saida(String saida, Palavras palavrasformatadas) {
        this.saida = saida;
        this.palavrasformatadas = palavrasformatadas;
    }
    Palavras formatacao = new Palavras();

    public void fazerSaida() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(saida))) {
            TreeMap<String, LinkedList<String>> mapaOrdenado = new TreeMap<>(palavrasformatadas.getMapa_palavra());

            for(String palavra : mapaOrdenado.keySet()) {
                bw.write(palavra + mapaOrdenado.get(palavra));
                bw.newLine();
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
