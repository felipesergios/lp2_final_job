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
            switch (selector){
                case 1:
                    System.out.println("Informe o nome do plano :\n");
                    String name_plain = scanner.nextLine();
                    System.out.println("Qual o preço desse plano ? :\n");
                    String price_new_plain = scanner.nextLine();
                    SubscriptionPlan new_plain = new SubscriptionPlan(name_plain);
                    new_plain.setPrice(price_new_plain);
                    subscriptionPlanController.store(new_plain);
                    System.out.println("Plano cadastrado !");
                    break;

                case 2:
                    for (SubscriptionPlan data : subscriptionPlanController.index()) {
                        System.out.println(data.getName() + " | Preço: " + data.getPrice());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome atual do plano: ");
                    String nomeAtual = scanner.nextLine();
                    System.out.print("Digite o novo nome do plano: ");
                    String novoNome = scanner.nextLine();
                    boolean atualizado = subscriptionPlanController.update(nomeAtual, novoNome);
                    if (atualizado) {
                        System.out.println("Plano atualizado com sucesso.");
                    } else {
                        System.out.println("Plano não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do plano que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = subscriptionPlanController.delete(nomeRemover);
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
        }while (selector != 0);
    }
}
