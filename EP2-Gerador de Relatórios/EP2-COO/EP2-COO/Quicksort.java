import java.util.*;

public class Quicksort implements EstrategiaOrdenacao {

    private static void troca(List<Produto> produtos, int i, int j) {
        Produto temp = produtos.get(i);
        produtos.set(i, produtos.get(j));
        produtos.set(j, temp);
    }

    private int particiona(List<Produto> produtos, int ini, int fim, Comparador<Produto> comparador) {

        Produto pivo = produtos.get(ini);
        int k = fim;

        for (int i = fim; i > ini; i--) {
            if (comparador.comparacao(produtos.get(i), pivo)) {
                troca(produtos, i, k);
                k--;
            }
        }
        troca(produtos, ini, k);
        return k;
    }

    @Override
    public void ordenar(List<Produto> produtos, Comparador<Produto> comparador) {
        ordena(produtos, 0, produtos.size()-1, comparador);
    }

    private void ordena(List<Produto> produtos, int ini, int fim, Comparador<Produto> comparador) {
        if (ini < fim) {

            int q = particiona(produtos, ini, fim, comparador);

            ordena(produtos, ini, q-1, comparador);
            ordena(produtos, q + 1, fim, comparador);
        }
    }
}