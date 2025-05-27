import java.util.*;

public class InsertionSort implements EstrategiaOrdenacao {

    @Override
    public void ordenar(List<Produto> produtos, Comparador<Produto> comparador) {
        for (int i = 1; i < produtos.size(); i++) {
            Produto chave = produtos.get(i);
            int j = i - 1;

            while (j >= 0 && comparador.comparacao(produtos.get(j),chave)) {
                produtos.set(j+1, produtos.get(j));
                j--;
            }
            produtos.set(j+1, chave);
        }
    }
}