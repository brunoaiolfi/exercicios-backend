import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<String> assentosDisponiveis;

    public Cinema() {
        // Inicializando assentos de A1 a F5
        this.assentosDisponiveis = new ArrayList<>();
        for (char fila = 'A'; fila <= 'F'; fila++) {
            for (int numero = 1; numero <= 5; numero++) {
                assentosDisponiveis.add(fila + String.valueOf(numero));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) throws Exception {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        throw new Exception("Filme não encontrado.");
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        // Verifica idade mínima
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        // Verifica se o assento está disponível
        if (!assentosDisponiveis.contains(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois o assento não está mais disponível!");
        }

        // Remove assento da lista de disponíveis e adiciona ingresso à lista de vendidos
        assentosDisponiveis.remove(assento);
        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);

        System.out.println(ingresso);
    }
}
