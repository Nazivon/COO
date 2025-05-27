import java.awt.Color;

public class ProdutoColorido implements Produto {
    private Produto produtoDecorado;
    private Color cor;

    public ProdutoColorido (Produto produtoDecorado, String corHex) {
        this.produtoDecorado = produtoDecorado;
        this.cor = Color.decode(corHex);
    }

    //sobrecarga do construtor
    public ProdutoColorido (Produto produtoDecorado, Color cor) {
        this.produtoDecorado = produtoDecorado;
        this.cor = cor;
    }

    @Override
    public String formataParaImpressao() {
        String hexColor = String.format("#%02x%02x%02x", cor.getRed(), cor.getGreen(), cor.getBlue());
        return "<span style='color:" + hexColor + "'>" + produtoDecorado.formataParaImpressao() + "</span>";
    }

    @Override
    public void setQtdEstoque(int qtdEstoque) {
        produtoDecorado.setQtdEstoque(qtdEstoque);
    }

    @Override
    public void setPreco(double preco) {
        produtoDecorado.setPreco(preco);
    }

    @Override
    public int getId() {
        return produtoDecorado.getId();
    }

    @Override
    public String getDescricao() {
        return produtoDecorado.getDescricao();
    }

    @Override
    public String getCategoria() {
        return produtoDecorado.getCategoria();
    }

    @Override
    public int getQtdEstoque() {
        return produtoDecorado.getQtdEstoque();
    }

    @Override
    public double getPreco() {
        return produtoDecorado.getPreco();
    }
}