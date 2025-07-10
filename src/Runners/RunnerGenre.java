package Runners;

import Controllers.GenreController;
import Models.Genre;

import java.util.Scanner;

public class RunnerGenre {
    public static void main(GenreController genreController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-GÊNEROS===" +
                    "\n1.->ADICIONAR NOVO GÊNERO DE MÚSICA" +
                    "\n2.->LISTAR GÊNEROS" +
                    "\n3.->ATUALIZAR UM GÊNERO" +
                    "\n4.->REMOVER UM GÊNERO" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine();

            switch (selector) {
                case 1:
                    System.out.println("Informe o nome do gênero:");
                    String nameGenre = scanner.nextLine();

                    try {
                        Genre newGenre = new Genre(nameGenre);
                        genreController.store(newGenre);
                        System.out.println("Novo gênero cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar gênero: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao cadastrar gênero. Detalhes: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Gêneros cadastrados:");
                        for (Genre data : genreController.index()) {
                            System.out.println("#==> " + data.getName() + " <==");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar gêneros: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome atual do gênero: ");
                    String currentName = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String newName = scanner.nextLine();

                    try {
                        boolean updated = genreController.update(currentName, newName);
                        if (updated) {
                            System.out.println("Gênero atualizado com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao atualizar gênero. Detalhes: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do gênero que deseja remover: ");
                    String nameToDelete = scanner.nextLine();

                    try {
                        boolean deleted = genreController.delete(nameToDelete);
                        if (deleted) {
                            System.out.println("Gênero removido com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao remover gênero. Detalhes: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do subprograma...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (selector != 0);
    }
}
