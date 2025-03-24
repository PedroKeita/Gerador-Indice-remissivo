import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        if(args.length < 3) {
            System.out.println("Ta faltando em");
            return;
        }

        Palavras formatacao = new Palavras();
        HashSet<String> palavras_chaves = new HashSet<>();


        //arquivo de texto das palavras-chave
        //Classe do Java para ler os argumentos em .txt
        try(BufferedReader br = new BufferedReader(new FileReader(args[1]))) {

            //ler cada linha do arquivo .txt e exibir
            String line;
            while((line = br.readLine()) != null) {
                palavras_chaves.add(line.toLowerCase().trim());
            }


        }catch(IOException e) {
            e.printStackTrace();
        }

        //arquivo de texto do texto
        //Classe do Java para ler os argumentos em .txt
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

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




        //
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]))) {
            for(String palavra : formatacao.getMapa_palavra().keySet()) {
                bw.write(palavra + formatacao.getMapa_palavra().get(palavra));
                bw.newLine();
            }


        }catch(IOException e) {
            e.printStackTrace();
        }


    }
}
