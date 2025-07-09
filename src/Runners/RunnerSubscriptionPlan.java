package Runners;

import Controllers.SubscriptionPlanController;
import Models.SubscriptionPlan;

import java.util.Scanner;

public class RunnerSubscriptionPlan {
    public static void main(SubscriptionPlanController subscriptionPlanController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-SUB-PLANS-===" +
                    "\n1.->ADICIONAR NOVO PLANO DE SUBINSCRIÇÃO" +
                    "\n2.->LISTAR PLANOS DISPONÍVEIS" +
                    "\n3.->ATUALIZAR UM PLANO" +
                    "\n4.->REMOVER UM PLANO" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine();

            switch (selector) {
                case 1:
                    try {
                        System.out.println("Informe o nome do plano:");
                        String namePlan = scanner.nextLine();
                        System.out.println("Qual o preço desse plano?");
                        String priceNewPlan = scanner.nextLine();

                        SubscriptionPlan newPlan = new SubscriptionPlan(namePlan);
                        newPlan.setPrice(priceNewPlan);
                        subscriptionPlanController.store(newPlan);

                        System.out.println("Plano cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao cadastrar plano. Detalhes: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        for (SubscriptionPlan data : subscriptionPlanController.index()) {
                            System.out.println(data.getName() + " | Preço: " + data.getPrice());
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar planos: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Digite o nome atual do plano: ");
                        String currentName = scanner.nextLine();
                        System.out.print("Digite o novo nome do plano: ");
                        String newName = scanner.nextLine();

                        boolean updated = subscriptionPlanController.update(currentName, newName);
                        if (updated) {
                            System.out.println("Plano atualizado com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao atualizar plano. Detalhes: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Digite o nome do plano que deseja remover: ");
                        String nameToRemove = scanner.nextLine();

                        boolean removed = subscriptionPlanController.delete(nameToRemove);
                        if (removed) {
                            System.out.println("Plano removido com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao remover plano. Detalhes: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (selector != 0);
    }
}
