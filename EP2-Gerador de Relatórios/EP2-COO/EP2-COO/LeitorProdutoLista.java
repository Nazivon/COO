import java.util.*;
import java.awt.Color;

public class LeitorProdutoLista implements LeitorProduto {
    private CriadorProduto criadorProduto;

    public LeitorProdutoLista (CriadorProduto criadorProduto) {
        this.criadorProduto = criadorProduto;
    }

    @Override
    public List<Produto> leProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(
                new ProdutoNegrito(
                        new ProdutoColorido(criadorProduto.carregaProduto(1, "O Hobbit", "Livros", 2, 34.90), "#FF0000")));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoNegrito(criadorProduto.carregaProduto(2, "Notebook Core i7", "Informatica", 5, 1999.90))));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(3, "Resident Evil 4", "Games", 7, 79.90), "#00FF00")));
        produtos.add(criadorProduto.carregaProduto(4, "iPhone", "Telefonia", 8, 4999.90));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(5, "Calculo I", "Livros", 20, 55.00)));
        produtos.add(
                new ProdutoColorido(
                        new ProdutoItalico(criadorProduto.carregaProduto(6, "Power Glove", "Games", 3, 499.90)),"#00FF00"));
        produtos.add(
                new ProdutoNegrito(
                        new ProdutoItalico(criadorProduto.carregaProduto(7, "Microsoft HoloLens", "Informatica", 1, 19900.00))));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(8, "OpenGL Programming Guide", "Livros", 4, 89.90)));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(9, "Vectrex", "Games", 1, 799.90),"#00FF00")));
        produtos.add(criadorProduto.carregaProduto(10, "Carregador iPhone", "Telefonia", 15, 499.90));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(11, "Introduction to Algorithms", "Livros", 7, 315.00)));
        produtos.add(
                new ProdutoColorido(
                        new ProdutoItalico(criadorProduto.carregaProduto(12, "Daytona USA (Arcade)", "Games", 1, 12000.00)),"#00FF00"));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(13, "Neuromancer", "Livros", 5, 45.00)));
        produtos.add(criadorProduto.carregaProduto(14, "Nokia 3100", "Telefonia", 4, 249.99));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(15, "Oculus Rift", "Games", 1, 3600.00),"#00FF00")));
        produtos.add(
                new ProdutoNegrito(
                        new ProdutoItalico(criadorProduto.carregaProduto(16, "Trackball Logitech", "Informatica", 1, 250.00))));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(17, "After Burner II (Arcade)", "Games", 2, 8900.0),"#00FF00")));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(18, "Assembly for Dummies", "Livros", 30, 129.90)));
        produtos.add(criadorProduto.carregaProduto(19, "iPhone (usado)", "Telefonia", 3, 3999.90));
        produtos.add(
                new ProdutoColorido(
                        new ProdutoNegrito(criadorProduto.carregaProduto(20, "Game Programming Patterns", "Livros", 1, 299.90)),"#FF0000"));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(21, "Playstation 2", "Games", 10, 499.90),"#00FF00")));
        produtos.add(criadorProduto.carregaProduto(22, "Carregador Nokia", "Telefonia", 14, 89.00));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoNegrito(
                                new ProdutoColorido(criadorProduto.carregaProduto(
                                        23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),"#0000FF"))));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(24, "Stunts", "Games", 3, 19.90),"#00FF00")));
        produtos.add(criadorProduto.carregaProduto(25, "Carregador Generico", "Telefonia", 9, 30.00));
        produtos.add(
                new ProdutoNegrito(
                        new ProdutoItalico(
                                new ProdutoColorido(criadorProduto.carregaProduto(
                                        26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),"#0000FF"))));
        produtos.add(criadorProduto.carregaProduto(27, "Nokia N-Gage", "Telefonia", 9, 699.00));
        produtos.add(
                new ProdutoColorido(
                        new ProdutoItalico(
                                new ProdutoNegrito(criadorProduto.carregaProduto(
                                        28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00))),"#0000FF"));
        produtos.add(
                new ProdutoItalico(
                        new ProdutoColorido(criadorProduto.carregaProduto(29, "Alone in The Dark", "Games", 11, 59.00),"#00FF00")));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00)));
        produtos.add(
                new ProdutoNegrito(
                        new ProdutoColorido(criadorProduto.carregaProduto(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),"#FF0000")));
        produtos.add(
                new ProdutoNegrito(criadorProduto.carregaProduto(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)));
        return produtos;
    }
}