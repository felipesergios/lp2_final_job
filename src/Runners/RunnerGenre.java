package Runners;

import Controllers.GenreController;
import Models.Genre;

import java.util.Scanner;

public class RunnerGenre {
    public static void main(GenreController genreController){
        Scanner scanner = new Scanner(System.in);
        int selector;
        do{
            System.out.println("===SUB-PROGRAMA-ADM-SUB-PLANS-===" +
                    "\n1.->ADICIONAR NOVO GENERO DE MUSICA" +
                    "\n2.->LISTAR GENEROS" +
                    "\n3.->ATUALIZAR UM GENERO" +
                    "\n4.->REMOVER UM GENERO" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine();
            switch (selector){
                case 1:
                    System.out.println("Informe o nome do genero :\n");
                    String name_genre = scanner.nextLine();
                    Genre new_genre = new Genre(name_genre);
                    genreController.store(new_genre);
                    System.out.println("Novo genero cadastrado !");
                    break;
                case 2:
                    for (Genre data : genreController.index()) {
                        System.out.println("#==>"+data.getName()+"<==");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome atual do genero: ");
                    String nomeAtual = scanner.nextLine();
                    System.out.print("Digite o novo nome : ");
                    String novoNome = scanner.nextLine();
                    boolean atualizado = genreController.update(nomeAtual, novoNome);
                    if (atualizado) {
                        System.out.println("atualizado com sucesso.");
                    } else {
                        System.out.println("Não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do genero que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = genreController.delete(nomeRemover);
                    if (removido) {
                        System.out.println("Plano removido com sucesso.");
                    } else {
                        System.out.println("Plano não encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opção Invalida!");
                    break;

            }
        }while (selector !=0);
    }
}
