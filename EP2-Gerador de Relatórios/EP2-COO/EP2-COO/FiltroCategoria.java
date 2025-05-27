import java.util.*;

public class FiltroCategoria implements Filtro {
    private String categoria;

    public FiltroCategoria (String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String obterFiltro() {
        return this.categoria;
    }

    @Override
    public List<Produto> filtrar(List<Produto> produtos) {
        produtos.removeIf(produto -> !(produto.getCategoria().equalsIgnoreCase(categoria)));
        return produtos;
    }
}