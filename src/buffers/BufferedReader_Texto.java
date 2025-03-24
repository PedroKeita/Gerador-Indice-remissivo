package buffers;
import palavra.Palavras;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class BufferedReader_Texto {
    String Texto;
    HashSet<String> palavras_chaves;

    Palavras formatacao = new Palavras();

    public BufferedReader_Texto(String Texto, HashSet<String> KeyWords) {
        this.Texto = Texto;
        this.palavras_chaves = KeyWords;
    }

    public void lerArquivoTexto () {
        //arquivo de texto do texto
        //Classe do Java para ler os argumentos em .txt
        try(BufferedReader br = new BufferedReader(new FileReader(Texto))) {

            //ler cada linha do arquivo .txt e exibir
            String line;
            int numero_linha = 1;

            while((line = br.readLine()) != null) {
                formatacao.divisaoPalavras(line,numero_linha, palavras_chaves);
                numero_linha++;
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Palavras getFormatacao() {
        return formatacao;
    }
}
