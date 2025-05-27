import java.util.*;

public interface EstrategiaOrdenacao {
    void ordenar (List<Produto> produtos, Comparador<Produto> comparador);
}