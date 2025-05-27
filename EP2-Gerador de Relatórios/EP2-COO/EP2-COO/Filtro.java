import java.util.*;

public interface Filtro {
    public List<Produto> filtrar (List<Produto> produtos);
    public String obterFiltro();
}