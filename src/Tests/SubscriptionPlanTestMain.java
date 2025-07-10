package Tests;
import Controllers.SubscriptionPlanController;
import Models.SubscriptionPlan;

import java.util.List;
import java.util.Scanner;

public class SubscriptionPlanTestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubscriptionPlanController controller = new SubscriptionPlanController();

        int opcao;
        do {
            System.out.println("\n===== MENU DE PLANOS DE ASSINATURA =====");
            System.out.println("1. Adicionar novo plano");
            System.out.println("2. Listar todos os planos");
            System.out.println("3. Buscar plano por nome");
            System.out.println("4. Atualizar nome de um plano");
            System.out.println("5. Remover plano");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n'

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do plano: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do plano: ");
                    String preco = scanner.nextLine();

                    SubscriptionPlan novoPlano = new SubscriptionPlan(nome);
                    novoPlano.setPrice(preco);
                    controller.store(novoPlano);
                    System.out.println("Plano adicionado com sucesso!");
                    break;

                case 2:
                    List<SubscriptionPlan> planos = controller.index();
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano cadastrado.");
                    } else {
                        System.out.println("Planos cadastrados:");
                        for (SubscriptionPlan plano : planos) {
                            System.out.println("- " + plano.getName() + " | Preço: " + plano.getPrice());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do plano que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();
                    SubscriptionPlan encontrado = controller.show(nomeBusca);
                    if (encontrado != null) {
                        System.out.println("Plano encontrado: " + encontrado.getName() + " | Preço: " + encontrado.getPrice());
                    } else {
                        System.out.println("Plano não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome atual do plano: ");
                    String nomeAtual = scanner.nextLine();
                    System.out.print("Digite o novo nome do plano: ");
                    String novoNome = scanner.nextLine();
                    boolean atualizado = controller.update(nomeAtual, novoNome);
                    if (atualizado) {
                        System.out.println("Plano atualizado com sucesso.");
                    } else {
                        System.out.println("Plano não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do plano que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = controller.delete(nomeRemover);
                    if (removido) {
                        System.out.println("Plano removido com sucesso.");
                    } else {
                        System.out.println("Plano não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}

