import java.io.PrintWriter;
import java.io.IOException;
import java.awt.Color;
import java.util.*;


public class GeradorDeRelatorios {
	private List<Produto> produtos;
	private EstrategiaOrdenacao algoritmo;
	private Comparador<Produto> criterio;
	private Filtro filtro;
	private Set<String> formatacao;

	//construtor
	public GeradorDeRelatorios(List<Produto> produtos, EstrategiaOrdenacao algoritmo, Comparador<Produto> criterio,
							   Filtro filtro, Set<String> formatacao){
		this.produtos = produtos;
		this.algoritmo = algoritmo;
		this.criterio = criterio;
		this.filtro = filtro;
		this.formatacao = formatacao;
	}

	//debug na tela
	public void debug(){
		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + filtro.obterFiltro() + "'");
	}

	//gera o relatorio em HTML
	public void geraRelatorio(String arquivoSaida) throws IOException {
		debug();
		int total = produtos.size();
		List<Produto> produtosFiltrados = filtro.filtrar(produtos);
		algoritmo.ordenar(produtosFiltrados, criterio);

		try (PrintWriter out = new PrintWriter(arquivoSaida)) {
			out.println("<!DOCTYPE html><html>");
			out.println("<head><title>Relatorio de produtos</title></head>");
			out.println("<body>");
			out.println("Relatorio de Produtos:");
			out.println("<ul>");

			FormatadorProduto formatador = new FormatadorProduto();

			for (Produto p : produtosFiltrados) {
				Produto produtoDecorado = formatador.aplicarFormatacao(p, formatacao);
				out.print("<li>");
				out.print(produtoDecorado.formataParaImpressao());
				out.println("</li>");
			}

			out.println("</ul>");
			out.println(produtosFiltrados.size() + " produtos listados, de um total de " + total + ".");
			out.println("</body>");
			out.println("</html>");
		}
	}


	public static void main(String[] args) {
		//trata dos argumentos passados em linha de comando
		Argumentador parseador = new Argumentador(args);

		//a lista de produtos
		List<Produto> produtos;

		//o criador de produto
		CriadorProduto criadorProduto = new CriadorProduto();

		//passa quem vai ler o produto para uma "Fabrica", que retorna uma classe que implementa LeitorProduto
		String arquivo = args[0];
		LeitorProduto leitorProduto = LeitorProdutoFabrica.getLeitorProduto(arquivo, criadorProduto);

		try {
			produtos = leitorProduto.leProdutos();
		} catch (IOException e) {
			System.err.println("Erro ao ler produtos: " + e.getMessage());
			return;
		}
		
		GeradorDeRelatorios gdr = new GeradorDeRelatorios(produtos,
									parseador.getAlgoritmo(),
									parseador.getCriterio(),
									parseador.getFiltro(),
									parseador.getOpcaoFormatacao());

		try {
			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}