import java.util.*;
import java.io.IOException;

public interface LeitorProduto {
    public List<Produto> leProdutos() throws IOException;
}