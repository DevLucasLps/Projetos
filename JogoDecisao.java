import java.util.Random;
import java.util.Scanner;

public class JogoDecisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int pontuacao = 0;
        int numeroAtual = random.nextInt(100) + 1;

        System.out.println("🎮 Bem-vindo ao jogo de decisão da NeuroLabs!");

        while (true) {
            System.out.println("\nNúmero atual: " + numeroAtual);
            System.out.print("Próximo número será maior ou menor? ");
            String escolha = scanner.nextLine().trim().toLowerCase();

            if (escolha.equals("sair")) {
                System.out.println("\nVocê saiu do jogo com " + pontuacao + " ponto(s). Até a próxima!");
                break;
            }

            if (!escolha.equals("maior") && !escolha.equals("menor")) {
                System.out.println("⚠️ Digite apenas 'maior', 'menor' ou 'sair'.");
                continue;
            }

            int novoNumero = random.nextInt(100) + 1;
            System.out.println("Novo número: " + novoNumero);

            if ((escolha.equals("maior") && novoNumero > numeroAtual) ||
                    (escolha.equals("menor") && novoNumero < numeroAtual)) {
                pontuacao++;
                System.out.println("✅ Acertou! Pontuação: " + pontuacao);
            } else {
                System.out.println("❌ Errou. Pontuação: " + pontuacao);
            }

            numeroAtual = novoNumero;
        }

        scanner.close();
    }
}