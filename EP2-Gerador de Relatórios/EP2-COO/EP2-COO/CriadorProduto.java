import java.util.*;

public class CriadorProduto {
    private FormatadorProduto formatadorProduto;

    public CriadorProduto() {
        this.formatadorProduto = new FormatadorProduto();
    }

    public Produto carregaProduto(int id, String descricao, String categoria, int qtdEstoque, double preco,
                                  boolean negrito, boolean italico, String cor) {
        Produto produto = new ProdutoPadrao(id, descricao, categoria, qtdEstoque, preco);

        Set<String> opcoesFormatacao = criarOpcoesFormatacao(negrito, italico, cor);
        produto = formatadorProduto.aplicarFormatacao(produto, opcoesFormatacao);

        return produto;
    }

    //Sobrecarga de método para LeitorProdutoLista
    public Produto carregaProduto(int id, String descricao, String categoria, int qtdEstoque, double preco) {
        Produto produto = new ProdutoPadrao(id, descricao, categoria, qtdEstoque, preco);
        return produto;
    }

    private Set<String> criarOpcoesFormatacao(boolean negrito, boolean italico, String cor) {
        Set<String> opcoesFormatacao = new HashSet<>();

        if (negrito) {
            opcoesFormatacao.add("negrito");
        }
        if (italico) {
            opcoesFormatacao.add("italico");
        }
        if (cor != null && !cor.isEmpty()) {
            opcoesFormatacao.add(cor);
        }
        return opcoesFormatacao;
    }
}