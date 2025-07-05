import Controllers.GenreController;
import Models.Genre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenreController genreController = new GenreController();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- GÊNEROS ---");
            System.out.println("1. Listar gêneros");
            System.out.println("2. Adicionar gênero");
            System.out.println("3. Mostrar gênero por nome");
            System.out.println("4. Remover gênero");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    System.out.println("\nGêneros cadastrados:");
                    for (Genre genre : genreController.index()) {
                        System.out.println("- " + genre.getName());
                    }
                    break;

                case 2:
                    System.out.print("Nome do gênero: ");
                    String name = scanner.nextLine();
                    genreController.store(new Genre(name));
                    System.out.println("Gênero adicionado!");
                    break;

                case 3:
                    System.out.print("Nome do gênero para mostrar: ");
                    String search = scanner.nextLine();
                    Genre found = genreController.show(search);
                    if (found != null) {
                        System.out.println("Gênero encontrado: " + found.getName());
                    } else {
                        System.out.println("Gênero não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do gênero para remover: ");
                    String removeName = scanner.nextLine();
                    if (genreController.delete(removeName)) {
                        System.out.println("Gênero removido.");
                    } else {
                        System.out.println("Gênero não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}
