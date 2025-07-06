import Controllers.GenreController;
import Controllers.SubscriptionPlanController;
import Controllers.UserController;
import Models.Genre;
import Models.User;
import Runners.RunnerSubscriptionPlan;
import Runners.RunnerUser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        SubscriptionPlanController subscriptionPlanController = new SubscriptionPlanController();
        RunnerUser runnerUser = new RunnerUser();
        RunnerSubscriptionPlan runnerSubscriptionPlan = new RunnerSubscriptionPlan();
        GenreController genreController = new GenreController();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- MENU PRINCIAL ---");
            System.out.println("1. Usuários");
            System.out.println("2. Planos de inscrição");
            System.out.println("3. Músicas");
            System.out.println("4. Playlists");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    System.out.println("\nCarregando sub-programa de usuários:");
                    RunnerUser.main(userController);
                    break;

                case 2:
                    System.out.print("\nCarregando sub-programa de planos de subinscrição:");
                    RunnerSubscriptionPlan.main(subscriptionPlanController);
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
                    for (User u : userController.index()) {
                        System.out.println(u.getName() + " - " + u.getEmail() + " (" + u.getSubscription_type().getName() + ")");
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
