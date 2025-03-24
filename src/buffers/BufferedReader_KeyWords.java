package buffers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class BufferedReader_KeyWords {
    String KeyWords;

    HashSet<String> palavras_chaves = new HashSet<>();
    public BufferedReader_KeyWords(String KeyWords) {
        this.KeyWords = KeyWords;
        lerPalavrasChaves();
    }

    public void lerPalavrasChaves() {
        //arquivo de texto das palavras-chave
        //Classe do Java para ler os argumentos em .txt
        try(
                BufferedReader br = new BufferedReader(new FileReader(KeyWords))) {

            //ler cada linha do arquivo .txt e exibir
            String line;
            while((line = br.readLine()) != null) {
                String[] palavras = line.toLowerCase().split("[^a-zA-Z0-9-]+");
                for (String palavra : palavras) {

                    palavras_chaves.add(palavra.trim());
                }
            }


        }catch(
                IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<String> getPalavrasChaves() {
        return palavras_chaves;
    }


}
