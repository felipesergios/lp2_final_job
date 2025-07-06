package Runners;

import Controllers.SubscriptionPlanController;

import java.util.Scanner;

public class RunnerSubscriptionPlan {
    public static void main(SubscriptionPlanController subscriptionPlanController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-SUB-PLANS-===" +
                    "\n1.->ADICIONAR NOVO USUÁRIO" +
                    "\n2.->LISTAR USUÁRIOS" +
                    "\n3.->ATUALIZAR USUÁRIO" +
                    "\n4.->REMOVER USUÁRIO" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine();
            switch (selector){
                case 1:
                    System.out.println("Digitou 1");
                    break;
                case 2:
                    System.out.println("Digitou 2");
                    break;
            }
        }while (selector != 0);
    }
}
