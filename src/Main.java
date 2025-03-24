import buffers.BufferedReader_KeyWords;
import buffers.BufferedReader_Texto;
import buffers.BufferedWriter_Saida;
import palavra.Palavras;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        if(args.length < 3) {
            System.out.println("Ta faltando em");
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
