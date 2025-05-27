import java.util.*;

public class FiltroTodos implements Filtro {

    @Override
    public String obterFiltro() {
        return "Todos os produtos";
    }

    @Override
    public List<Produto> filtrar(List<Produto> produtos) {
        return produtos;
    }
}