package Runners;

import Models.*;
import Controllers.UserController;

import java.util.Scanner;

public class UserTestMain {
    public static void main(String[] args) {
        UserController service = new UserController();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Atualizar nome");
            System.out.println("4. Remover usuário");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Tipo (free/premium): ");
                    String tipo = scanner.nextLine();

                    User user = tipo.equalsIgnoreCase("premium")
                            ? new User_Premium(nome, email , new SubscriptionPlan())
                            : new User_Free(nome, email,new SubscriptionPlan());

                    service.store(user);
                    System.out.println("Usuário adicionado!");
                    break;

                case 2:
                    for (User u : service.index()) {
                        System.out.println(u.getName() + " - " + u.getEmail() + " (" + u.getSubscription_type().getName() + ")");
                    }
                    break;

                case 3:
                    System.out.print("Email do usuário: ");
                    String emailToUpdate = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    if (service.update(emailToUpdate, novoNome)) {
                        System.out.println("Usuário atualizado!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Email do usuário: ");
                    String emailToRemove = scanner.nextLine();
                    if (service.delete(emailToRemove)) {
                        System.out.println("Usuário removido!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}

