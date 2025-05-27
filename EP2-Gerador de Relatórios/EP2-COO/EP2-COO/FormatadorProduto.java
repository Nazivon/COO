import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FormatadorProduto {
    public Produto aplicarFormatacao (Produto produto, Set<String> opcoesFormatacao) {
        if (opcoesFormatacao.isEmpty()) {
            return produto;
        }

        for (String formato : opcoesFormatacao) {
            switch(formato.toLowerCase()) {
                case "negrito":
                    produto = new ProdutoNegrito(produto);
                    break;
                case "italico":
                    produto = new ProdutoItalico(produto);
                    break;
                default:
                    if (isCorHex(formato)) {
                        produto = new ProdutoColorido(produto, formato);
                    }
            }
        }
        return produto;
    }

    private boolean isCorHex(String formato) {
        // Padrão para verificar se é uma cor hexadecimal
        Pattern pattern = Pattern.compile("^#[0-9A-Fa-f]{6}$");
        Matcher matcher = pattern.matcher(formato);
        return matcher.matches();
    }

    // Verifica se o produto já possui a formatação especificada
    private boolean produtoPossuiFormatacao(Produto produto, Set<String> opcoesFormatacao) {
        for (String opcao : opcoesFormatacao) {
            if (opcao.equals("negrito") && !(produto instanceof ProdutoNegrito)) {
                return false;
            }
            if (opcao.equals("italico") && !(produto instanceof ProdutoItalico)) {
                return false;
            }
            if (opcao.startsWith("#") && !(produto instanceof ProdutoColorido)) {
                return false;
            }
        }
        return true;
    }
}