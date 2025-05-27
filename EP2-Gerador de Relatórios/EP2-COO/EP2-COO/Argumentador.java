import java.io.IOException;
import java.util.*;

public class Argumentador {
    private EstrategiaOrdenacao algoritmo;
    private Comparador<Produto> criterio;
    private Filtro filtro;
    private Set<String> opcaoFormatacao;

    public Argumentador(String[] argsComando) {
        if(argsComando.length < 4) {
            imprimeManualDeUso();
        }
        String[] args = inicializarArgumentos(argsComando);

        try {
            this.algoritmo = passaAlgoritmo(args[0]);
            this.criterio = passaCriterioOrdenacao(args[1]);
            this.filtro = passaCriterioFiltragem(args[2], args[3]);
            if (args.length >= 5) {
                this.opcaoFormatacao = passaOpcaoFormatacao(Arrays.copyOfRange(args, 4, args.length));
            } else {
                this.opcaoFormatacao = Collections.emptySet();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            imprimeManualDeUso();
        }
    }

    //inicializa os argumentos da linha de comando, seja começando com arquivo CSV ou não
    private static String[] inicializarArgumentos(String[] args) {
        String arquivo = args[0];
        String[] argsLinha;

        // Se o primeiro argumento for um arquivo
        if (arquivo.contains(".")) {
            argsLinha = new String[args.length - 1];
            System.arraycopy(args, 1, argsLinha, 0, args.length - 1);
        } else {
            argsLinha = args;
        }
        return argsLinha;
    }

    //imprime manual de uso da classe
    protected static void imprimeManualDeUso() {
        System.out.println("Uso:");
        System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <arquivo CSV ou nenhum> <algoritmo> " +
                "<criterio de ordenacao> <criterio de filtragem> <parametro de filtragem> <opcoes de formatacao>");
        System.out.println("Onde:");
        System.out.println("\talgoritmo: 'quick' ou 'insertion'");
        System.out.println("\tcriterio de ordenacao: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou " +
                "'descricao_d' ou 'estoque_d', para ordenacao crescente ou decrescente");
        System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou " +
                "'descricao' ou 'intervalo_preco'");
        System.out.println("\tparametro de filtragem: argumentos adicionais necessarios para a filtragem; para todos, " +
                "use 'nenhum', para intervalo de preco, use numero_numero (ex: 20.4_30.5)");
        System.out.println("\topcoes de formatacao: 'negrito' e/ou 'italico e/ou codigo Hex da cor'");
        System.out.println();
        System.exit(1);
    }

    private EstrategiaOrdenacao passaAlgoritmo(String arg) {
        switch (arg.toLowerCase()) {
            case "quick":
                return new Quicksort();
            case "insertion":
                return new InsertionSort();
            default:
                throw new IllegalArgumentException("Algoritmo inválido: " + arg);
        }
    }

    private Comparador<Produto> passaCriterioOrdenacao(String arg) {
        boolean ordemCrescente = false;
        if (arg.endsWith("_c")) {
            ordemCrescente = true;
        } else if (arg.endsWith("_d")) {
            ordemCrescente = false;
        } else {
            throw new IllegalArgumentException("Critério de ordenação inválido: " + arg);
        }

        String criterio = arg.substring(0, arg.length() - 2).toLowerCase();
        switch (criterio) {
            case "preco":
                return new CriterioOrdenacaoPreco(ordemCrescente);
            case "descricao":
                return new CriterioOrdenacaoDescricao(ordemCrescente);
            case "estoque":
                return new CriterioOrdenacaoEstoque(ordemCrescente);
            default:
                throw new IllegalArgumentException("Critério de ordenação inválido: " + arg);
        }
    }

    private Filtro passaCriterioFiltragem (String arg, String argFiltro) {
        switch (arg.toLowerCase()) {
            case "todos":
                return new FiltroTodos();
            case "estoque_menor_igual":
                return new FiltroEstoque(Integer.parseInt(argFiltro));
            case "categoria_igual":
                return new FiltroCategoria(argFiltro.toLowerCase());
            case "descricao":
                return new FiltroDescricao(argFiltro);
            case "intervalo_preco":
                Set<Double> intervalo = IntervaloUtil.leIntervalo(argFiltro);
                if (intervalo.size() != 2) {
                    throw new IllegalArgumentException("Intervalo deve conter exatamente dois valores.");
                }
                Iterator<Double> iterador = intervalo.iterator();
                double precoMin = iterador.next();
                double precoMax = iterador.next();
                return new FiltroPreco(precoMin, precoMax);
            default:
                throw new IllegalArgumentException("Critério de filtragem inválido: " + arg);
        }
    }

    private Set<String> passaOpcaoFormatacao(String[] args) {
        Set<String> opcoesFormato = new HashSet<>();
        for (String arg : args) {
            if (arg.equalsIgnoreCase("negrito") || arg.equalsIgnoreCase("italico") || arg.matches("^#[0-9A-Fa-f]{6}$")) {
                opcoesFormato.add(arg.toLowerCase()); // Adiciona formatos aceitos, convertendo para minúsculas
            }
        }
        return opcoesFormato;
    }

    //getters
    public EstrategiaOrdenacao getAlgoritmo() {
        return algoritmo;
    }

    public Comparador<Produto> getCriterio() {
        return criterio;
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public Set<String> getOpcaoFormatacao() {
        return opcaoFormatacao;
    }

}