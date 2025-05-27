import java.util.*;

public class FiltroDescricao implements Filtro {
    private String substring;

    public FiltroDescricao (String substring) {
        this.substring = substring.toLowerCase();
    }

    @Override
    public String obterFiltro() {
        return "Descricao contém a substring " + this.substring;
    }

    @Override
    public List<Produto> filtrar (List<Produto> produtos) {
        produtos.removeIf(produto -> !(contemDescricao(produto, substring)));
        return produtos;
    }

    private boolean contemDescricao(Produto produto, String substring) {
        String descricao = produto.getDescricao().toLowerCase();
        return (descricao.contains(substring));
    }
}