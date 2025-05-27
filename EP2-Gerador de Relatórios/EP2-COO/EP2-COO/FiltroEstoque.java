import java.util.*;

public class FiltroEstoque implements Filtro {
    private int quantidade;

    public FiltroEstoque (int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String obterFiltro() {
        return "Estoque menor ou igual a " + this.quantidade;
    }

    @Override
    public List<Produto> filtrar (List<Produto> produtos) {
        produtos.removeIf(produto -> produto.getQtdEstoque() > quantidade);
        return produtos;
    }
}