import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homem Aranha", 30.0, 12));
        cinema.adicionarFilme(new Filme("Batman", 25.0, 14));
        cinema.adicionarFilme(new Filme("Toy Story", 20.0, 0));
        cinema.adicionarFilme(new Filme("A Origem", 28.0, 16));
        cinema.adicionarFilme(new Filme("Velozes e Furiosos", 22.0, 14));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();

                Filme filme = cinema.buscarFilme(nomeFilme);

                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                cinema.venderIngresso(cliente, filme, assento);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nDeseja comprar outro ingresso? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}
