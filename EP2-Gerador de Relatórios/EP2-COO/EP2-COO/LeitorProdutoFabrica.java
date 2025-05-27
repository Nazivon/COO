public class LeitorProdutoFabrica {
    public static LeitorProduto getLeitorProduto (String arquivo, CriadorProduto criadorProduto) {
        if (arquivo.toLowerCase().endsWith(".csv")) {
            return new LeitorProdutoCSV(arquivo, criadorProduto);
        }
        return new LeitorProdutoLista(criadorProduto);
    }
}