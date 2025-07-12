import Controllers.*;
import Runners.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        SubscriptionPlanController subscriptionPlanController = new SubscriptionPlanController();
        RunnerUser runnerUser = new RunnerUser();
        RunnerPlaylist runnerPlaylist = new RunnerPlaylist();
        RunnerSubscriptionPlan runnerSubscriptionPlan = new RunnerSubscriptionPlan();
        GenreController genreController = new GenreController();
        PlaylistController playlistController = new PlaylistController();
        MusicController musicController = new MusicController();
        Scanner scanner = new Scanner(System.in);


        int option = -1; // Iniciar a variavel com qualquer valor negativo, fora do escopo pra não fechar o programa
        //Principal
        do {
            showMenu();
            try {
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
                        System.out.print("\nCarregando sub-programa de Generos Musicais: ");
                        RunnerGenre.main(genreController);
                        break;

                    case 4:
                        System.out.print("\nCarregando sub-programa de Músicas: ");
                        RunnerMusic.main(musicController, userController, playlistController);
                        break;
                    case 5:
                        System.out.print("\nCarregando sub-programa de Playlist: ");
                        RunnerPlaylist.main(playlistController);
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Digite um valor inteiro ! ");
                scanner.nextLine(); // Necessário pra corrigir erro de buffer
            }
        } while (option != 0);


        scanner.close();
    }
    public static void showMenu(){
        System.out.println("\n--- MENU PRINCIAL ---");
        System.out.println("1. Usuários");
        System.out.println("2. Planos de inscrição");
        System.out.println("3. Gêneros Musicais");
        System.out.println("4. Músicas");
        System.out.println("5. Playlists");
        System.out.println("0. Sair");
    }
}


