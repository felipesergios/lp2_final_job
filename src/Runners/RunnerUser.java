package Runners;

import Controllers.UserController;
import Models.*;

import java.util.Scanner;

public class RunnerUser {
    public static void main(UserController userController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-USERS-===" +
                    "\n1.->ADICIONAR NOVO USUÁRIO" +
                    "\n2.->LISTAR USUÁRIOS" +
                    "\n3.->ATUALIZAR USUÁRIO" +
                    "\n4.->REMOVER USUÁRIO" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (selector) {
                case 1:
                    System.out.println("Informe o nome: ");
                    String name = scanner.nextLine();
                    System.out.println("Informe o E-mail: ");
                    String email = scanner.nextLine();
                    System.out.println("Escolha qual o tipo desse usuário \n" +
                            "A->Artista\n" +
                            "F->Free\n" +
                            "P->Premium");
                    String tipo = scanner.nextLine();

                    try {
                        User user;

                        if (tipo.equalsIgnoreCase("A")) {
                            user = new Artist(name, email, new SubscriptionPlan(tipo));
                        } else if (tipo.equalsIgnoreCase("P")) {
                            user = new User_Premium(name, email, new SubscriptionPlan(tipo));
                        } else {
                            user = new User_Free(name, email, new SubscriptionPlan(tipo));
                        }

                        userController.store(user);
                        System.out.println("Cadastro de usuário realizado com sucesso.");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao cadastrar usuário. Detalhes: " + e.getMessage());
                    }
                    break;

                case 2:
                    for (User u : userController.index()) {
                        System.out.println(u.getName() + " - " + u.getEmail() + " (" + u.getSubscription_type().getName() + ")");
                    }
                    break;

                case 3:
                    System.out.println("Informe o e-mail do usuário a ser atualizado: ");
                    String emailToUpdate = scanner.nextLine();
                    System.out.println("Informe o novo valor para o nome do usuário:");
                    String nameUpdate = scanner.nextLine();

                    try {
                        if (userController.update(emailToUpdate, nameUpdate)) {
                            System.out.println("Usuário atualizado com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao atualizar usuário. Detalhes: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Informe o e-mail do usuário a ser deletado: ");
                    String emailToDelete = scanner.nextLine();

                    try {
                        if (userController.delete(emailToDelete)) {
                            System.out.println("Usuário deletado com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao deletar usuário. Detalhes: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (selector != 0);


    }
}
