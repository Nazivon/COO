public class CriterioOrdenacaoPreco implements Comparador<Produto> {

    private boolean ordem;

    public CriterioOrdenacaoPreco (boolean ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean comparacao (Produto a, Produto b) {
        return ((a.getPreco() > b.getPreco()) == ordem);
    }
}