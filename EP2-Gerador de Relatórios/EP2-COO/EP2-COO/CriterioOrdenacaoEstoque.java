public class CriterioOrdenacaoEstoque implements Comparador<Produto> {

    private boolean ordem;

    public CriterioOrdenacaoEstoque (boolean ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean comparacao (Produto a, Produto b) {
        return ((a.getQtdEstoque() > b.getQtdEstoque()) == ordem);
    }
}