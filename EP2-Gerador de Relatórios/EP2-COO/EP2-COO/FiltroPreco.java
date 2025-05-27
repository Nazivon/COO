import java.util.*;

public class FiltroPreco implements Filtro {
    private double limiteInferior;
    private double limiteSuperior;

    public FiltroPreco (double limiteInferior, double limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    @Override
    public String obterFiltro() {
        return "Preco no intervalo de " + this.limiteInferior + " a " + this.limiteSuperior;
    }

    @Override
    public List<Produto> filtrar (List<Produto> produtos) {
        produtos.removeIf(produto -> checaPreco(produto, limiteInferior, limiteSuperior));
       return produtos;
    }

    private boolean checaPreco(Produto produto, double limiteInferior, double limiteSuperior) {
        double preco = produto.getPreco();
        return (preco < limiteInferior || preco > limiteSuperior);
    }
}