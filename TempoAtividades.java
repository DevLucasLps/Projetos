import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TempoAtividades {

    static class Atividade {
        String nome;
        int duracao;

        Atividade(String nome, int duracao) {
            this.nome = nome;
            this.duracao = duracao;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🕒 Quanto tempo você tem disponível? (Ex: 10m, 1.5h, 2h)");
        System.out.print("> ");
        String entrada = scanner.nextLine().trim().toLowerCase();

        Integer minutosTotais = converterParaMinutos(entrada);

        if (minutosTotais == null) {
            System.out.println("❌ Não foi possível entender o tempo inserido.");
            return;
        }

        System.out.printf("\n⏱️ Você tem %s (%d minutos). Aqui estão sugestões para aproveitar bem esse tempo:\n\n",
                entrada, minutosTotais);

        List<Atividade> atividades = obterTodasAtividadesOrdenadas();
        int tempoRestante = minutosTotais;

        for (Atividade atividade : atividades) {
            if (atividade.duracao <= tempoRestante) {
                System.out.printf("✅ %s (%d min)\n", atividade.nome, atividade.duracao);
                tempoRestante -= atividade.duracao;
                System.out.printf("Restou: %d min\n\n", tempoRestante);
            }
            if (tempoRestante < 5) break;
        }

        if (tempoRestante > 0 && tempoRestante < 5) {
            System.out.println("🧘 Tempo final pequeno — respire fundo, levante ou beba água!");
        }

        scanner.close();
    }

    public static Integer converterParaMinutos(String entrada) {
        try {
            if (entrada.contains("h")) {
                entrada = entrada.replace("h", "").trim();
                double horas = Double.parseDouble(entrada);
                return (int) (horas * 60);
            } else if (entrada.contains("m")) {
                entrada = entrada.replace("m", "").trim();
                return (int) Double.parseDouble(entrada);
            } else {
                return (int) Double.parseDouble(entrada);
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static List<Atividade> obterTodasAtividadesOrdenadas() {
        List<Atividade> lista = new ArrayList<>();

  )
        lista.add(new Atividade("Projeto pessoal", 90));
        lista.add(new Atividade("Estudo aprofundado", 90));
        lista.add(new Atividade("Tarefa doméstica longa", 90));

        lista.add(new Atividade("Estudar um módulo", 45));
        lista.add(new Atividade("Escrever um texto", 45));
        lista.add(new Atividade("Resolver exercícios", 45));

        lista.add(new Atividade("Assistir a uma videoaula", 20));
        lista.add(new Atividade("Fazer uma caminhada curta", 20));

        lista.add(new Atividade("Ler um artigo curto", 10));
        lista.add(new Atividade("Revisar anotações", 10));
        lista.add(new Atividade("Meditar", 10));

        lista.add(new Atividade("Beber água", 5));
        lista.add(new Atividade("Levantar e alongar", 5));
        lista.add(new Atividade("Respirar fundo", 5));

        return lista;
    }
}
