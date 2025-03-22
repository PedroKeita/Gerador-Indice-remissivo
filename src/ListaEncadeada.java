import java.util.*;

class ListaEncadeada {
    class Nodo {
        String palavra;
        List<Integer> linhas;
        Nodo proximo;

        Nodo(String palavra) {
            this.palavra = palavra;
            this.linhas = new ArrayList<>();
            this.proximo = null;
        }
    }

    private Nodo inicio;

    public void inserir(String palavra) {
        Nodo novo = new Nodo(palavra);
        if (inicio == null) {
            inicio = novo;
        } else {
            Nodo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void adicionarLinha(String palavra, int linha) {
        Nodo atual = inicio;
        while (atual != null) {
            if (atual.palavra.equals(palavra)) {
                if (!atual.linhas.contains(linha)) {
                    atual.linhas.add(linha);
                }
                return;
            }
            atual = atual.proximo;
        }
    }

    public List<String> obterOrdenado() {
        List<String> lista = new ArrayList<>();
        Nodo atual = inicio;
        while (atual != null) {
            lista.add(atual.palavra);
            atual = atual.proximo;
        }
        Collections.sort(lista);
        return lista;
    }

    public Map<String, List<Integer>> obterIndiceOrdenado() {
        Map<String, List<Integer>> mapa = new TreeMap<>();
        Nodo atual = inicio;
        while (atual != null) {
            if (!atual.linhas.isEmpty()) {
                mapa.put(atual.palavra, new ArrayList<>(atual.linhas));
            }
            atual = atual.proximo;
        }
        return mapa;
    }
}
