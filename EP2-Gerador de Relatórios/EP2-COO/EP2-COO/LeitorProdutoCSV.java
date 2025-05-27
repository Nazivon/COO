import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorProdutoCSV implements LeitorProduto {
    private String arquivoCSV;
    private CriadorProduto criadorProduto;

    public LeitorProdutoCSV(String arquivoCSV, CriadorProduto criadorProduto) {
        this.arquivoCSV = arquivoCSV;
        this.criadorProduto = criadorProduto;
    }

    @Override
    public List<Produto> leProdutos() throws IOException {
        List<Produto> produtos = new ArrayList<>();
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(", ");
                int id = Integer.parseInt(campos[0]);
                String descricao = campos[1];
                String categoria = campos[2];
                int qtdEstoque = Integer.parseInt(campos[3]);
                double preco = Double.parseDouble(campos[4]);
                boolean negrito = Boolean.parseBoolean(campos[5]);
                boolean italico = Boolean.parseBoolean(campos[6]);
                String cor = campos[7];

                Produto produto = criadorProduto.carregaProduto(id, descricao, categoria, qtdEstoque, preco, negrito, italico, cor);
                produtos.add(produto);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}