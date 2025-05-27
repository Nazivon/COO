public class CriterioOrdenacaoDescricao implements Comparador<Produto> {

    private boolean ordem;

    public CriterioOrdenacaoDescricao (boolean ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean comparacao (Produto a, Produto b) {
        return ((a.getDescricao().compareToIgnoreCase(b.getDescricao()) > 0) == ordem);
    }
}