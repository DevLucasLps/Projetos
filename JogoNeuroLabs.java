import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class JogoNeuroLabs {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int totalRodadas = 0;
    private static int totalAcertos = 0;

    public static void main(String[] args) {
        System.out.println("🧠 Bem-vindo ao Desafio Cognitivo da NeuroLabs!");

        boolean jogarNovamente;
        do {
            jogarRodada();
            jogarNovamente = desejaJogarNovamente();
        } while (jogarNovamente);

        System.out.println("\n📊 Resultados Finais:");
        System.out.println("Rodadas jogadas: " + totalRodadas);
        System.out.println("Rodadas com acerto: " + totalAcertos);
        System.out.println("👋 Obrigado por jogar!");
    }

    private static void jogarRodada() {
        totalRodadas++;
        int dificuldade = escolherDificuldade();
        int numeroMaximo = definirLimite(dificuldade);
        int numeroSecreto = random.nextInt(numeroMaximo) + 1;

        List<Integer> historicoChutes = new ArrayList<>();
        boolean acertou = false;

        System.out.println("\nRodada iniciada! Tente adivinhar o número entre 1 e " + numeroMaximo + ".");

        for (int tentativa = 1; tentativa <= 10; tentativa++) {
            System.out.print("\nTentativa " + tentativa + " de 10. Digite seu chute (ou 'H' para ver histórico): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("H")) {
                mostrarHistorico(historicoChutes);
                tentativa--; // Não conta como tentativa
                continue;
            }

            int chute;
            try {
                chute = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Digite um número ou 'H'");
                tentativa--;
                continue;
            }

            historicoChutes.add(chute);

            if (chute == numeroSecreto) {
                System.out.println("🎉 Parabéns! Você acertou o número!");
                totalAcertos++;
                acertou = true;
                break;
            } else if (chute < numeroSecreto) {
                System.out.println("🔺 O número secreto é MAIOR.");
            } else {
                System.out.println("🔻 O número secreto é MENOR.");
            }
        }

        if (!acertou) {
            System.out.println("❌ Você usou todas as tentativas. O número era: " + numeroSecreto);
        }
    }

    private static int escolherDificuldade() {
        System.out.println("\nEscolha a dificuldade:");
        System.out.println("1 - Fácil (1 a 50)");
        System.out.println("2 - Médio (1 a 100)");
        System.out.println("3 - Difícil (1 a 200)");
        while (true) {
            System.out.print("Sua escolha: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": return 1;
                case "2": return 2;
                case "3": return 3;
                default:
                    System.out.println("⚠️ Escolha inválida. Digite 1, 2 ou 3.");
            }
        }
    }

    private static int definirLimite(int dificuldade) {
        switch (dificuldade) {
            case 1: return 50;
            case 2: return 100;
            case 3: return 200;
            default: return 100;
        }
    }

    private static void mostrarHistorico(List<Integer> historico) {
        if (historico.isEmpty()) {
            System.out.println("📭 Nenhum chute feito ainda.");
        } else {
            System.out.println("📜 Histórico de chutes: " + historico);
        }
    }

    private static boolean desejaJogarNovamente() {
        System.out.print("\n🔁 Deseja jogar outra rodada? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }
}
