import buffers.BufferedReader_KeyWords;
import buffers.BufferedReader_Texto;
import buffers.BufferedWriter_Saida;
import palavra.Palavras;

public class Main {
    public static void main(String[] args) {

        System.out.println("Antes de começar, verifique se preencheu os arquivos .txt corretamente");
        if(args.length < 3) {
            System.out.println("Formato indevido: colocar nos argumentos <texto.txt> <palavras.txt> <saida.txt>");
            return;
        }

        String Texto = args[0];
        String KeyWords = args[1];
        String Saida = args[2];

        BufferedReader_KeyWords Buffer_KeyWords = new BufferedReader_KeyWords(KeyWords);
        Buffer_KeyWords.lerPalavrasChaves();
        BufferedReader_Texto Buffer_Texto = new BufferedReader_Texto(Texto,Buffer_KeyWords.getPalavrasChaves());
        Buffer_Texto.lerArquivoTexto();

        Palavras palavrasFormatadas = Buffer_Texto.getFormatacao();

        BufferedWriter_Saida Buffer_Saida = new BufferedWriter_Saida(Saida,palavrasFormatadas);
        Buffer_Saida.fazerSaida();
    }


}
