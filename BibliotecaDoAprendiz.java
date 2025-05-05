import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaDoAprendiz {

    static class Livro {
        String titulo;
        String autor;

        Livro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        @Override
        public String toString() {
            return titulo + " - " + autor;
        }
    }

    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        do {
            System.out.println("\n=== Biblioteca do Aprendiz ===");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Editar livro");
            System.out.println("4. Remover livro");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    editarLivro();
                    break;
                case 4:
                    removerLivro();
                    break;
                case 5:
                    System.out.println("Saindo da biblioteca... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 5);
    }

    static void adicionarLivro() {
        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();
        livros.add(new Livro(titulo, autor));
        System.out.println("✅ Livro adicionado!");
    }

    static void listarLivros() {
        System.out.println("\n📚 Lista de livros:");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("[" + i + "] " + livros.get(i));
            }
        }
    }

    static void editarLivro() {
        listarLivros();
        if (livros.isEmpty()) return;

        System.out.print("Digite o número do livro a editar: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < livros.size()) {
            System.out.print("Digite o novo título: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Digite o novo autor: ");
            String novoAutor = scanner.nextLine();
            livros.set(index, new Livro(novoTitulo, novoAutor));
            System.out.println("✏️ Livro editado!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    static void removerLivro() {
        listarLivros();
        if (livros.isEmpty()) return;

        System.out.print("Digite o número do livro a remover: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < livros.size()) {
            livros.remove(index);
            System.out.println("🗑️ Livro removido!");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
