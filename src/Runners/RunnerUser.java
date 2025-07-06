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
                    if (tipo.equalsIgnoreCase("A")){
                        User user = new Artist(name,email,new SubscriptionPlan(tipo));
                        userController.store(user);
                        System.out.println("Cadastro De Artista Realizado");
                    } else if (tipo.equalsIgnoreCase("P")) {
                        User user = new User_Premium(name,email,new SubscriptionPlan(tipo));
                        userController.store(user);
                        System.out.println("Cadastro De Usuario premium Realizado");
                    } else {
                        User user = new User_Free(name,email,new SubscriptionPlan(tipo));
                        userController.store(user);
                        System.out.println("Cadastro De Usuario free Realizado");
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
                    System.out.println("Informe o novo valor para o nome do usuário :");
                    String name_update = scanner.nextLine();
                    if(userController.update(emailToUpdate,name_update)){
                        System.out.println("Usuário atualizado");
                    }else{
                        System.out.println("falha na atualização");
                    }
                case 4:
                    System.out.println("Informe o e-mail do usuário a ser deletado: ");
                    String emailToDelete = scanner.nextLine();
                    if(userController.delete(emailToDelete)){
                        System.out.println("Usuário Deletado");
                    }else{
                        System.out.println("falha no delete");
                    }
                case 0:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (selector != 0);

        //scanner.close(); // Boa prática: fechar o scanner
    }
}
