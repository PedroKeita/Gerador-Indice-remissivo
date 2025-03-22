import java.io.*;
import java.util.*;


public class IndiceRemissivo {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java IndiceRemissivo <arquivo_palavras-chave> <arquivo_texto> <arquivo_saida>");
            return;
        }

        String arquivoPalavrasChave = args[0];
        String arquivoTexto = args[1];
        String arquivoSaida = args[2];

        Set<String> hashIndice = new HashSet<>();
        ListaEncadeada listaIndice = new ListaEncadeada();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPalavrasChave))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim().toLowerCase();
                if (!linha.isEmpty()) {
                    hashIndice.add(linha);
                    listaIndice.inserir(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de palavras-chave: " + e.getMessage());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoTexto))) {
            String linha;
            int numeroLinha = 1;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String palavra : palavras) {
                    if (hashIndice.contains(palavra)) {
                        listaIndice.adicionarLinha(palavra, numeroLinha);
                    }
                }
                numeroLinha++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de texto: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
            Map<String, List<Integer>> indiceOrdenado = listaIndice.obterIndiceOrdenado();
            for (Map.Entry<String, List<Integer>> entry : indiceOrdenado.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
            System.out.println("Índice remissivo gerado com sucesso no arquivo: " + arquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de saída: " + e.getMessage());
        }
    }
}
