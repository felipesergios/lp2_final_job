package Tests;

import Controllers.MusicController;
import Controllers.UserController;
import Models.*;

import java.util.List;
import java.util.Scanner;

public class MusicTestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicController musicController = new MusicController();
        UserController userController = new UserController();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar artista");
            System.out.println("2. Cadastrar música");
            System.out.println("3. Listar músicas");
            System.out.println("4. Buscar música");
            System.out.println("5. Atualizar nome de música");
            System.out.println("6. Deletar música");
            System.out.println("7. Mostrar músicas de um artista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do artista: ");
                    String name = scanner.nextLine();
                    System.out.print("Email do artista: ");
                    String email = scanner.nextLine();
                    System.out.print("Plano de assinatura (ex: PREMIUM, FREE): ");
                    String plan = scanner.nextLine().toUpperCase();

                    Artist artist = new Artist(name, email, new SubscriptionPlan(plan));
                    userController.store(artist);
                    break;

                case 2:
                    System.out.print("Email do artista responsável pela música: ");
                    String artistEmail = scanner.nextLine();
                    User user = userController.show(artistEmail);

                    if (user instanceof Artist) {
                        Artist musicArtist = (Artist) user;

                        System.out.print("Nome da música: ");
                        String musicName = scanner.nextLine();
                        System.out.print("Gênero: ");
                        String genreName = scanner.nextLine();
                        Genre genre = new Genre(genreName);
                        System.out.print("Duração (segundos): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer

                        Music music = new Music(musicName, genre, duration, musicArtist);
                        musicController.store(music);
                        musicArtist.setMusicas(music); // adicionar à lista do artista
                        System.out.println("✅ Música cadastrada com sucesso!");
                    } else {
                        System.out.println("❌ Artista não encontrado com esse email.");
                    }
                    break;

                case 3:
                    List<Music> allMusic = musicController.index();
                    if (allMusic.isEmpty()) {
                        System.out.println("Nenhuma música cadastrada.");
                    } else {
                        for (Music m : allMusic) {
                            System.out.println("- " + m.getName() + " | " +
                                    m.getArtist().getName() + " | " +
                                    m.getGenre().getName() + " | " +
                                    m.getDuration() + "s");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nome da música a buscar: ");
                    String musicToFind = scanner.nextLine();
                    Music found = musicController.show(musicToFind);
                    if (found != null) {
                        System.out.println("🎵 Encontrada:");
                        System.out.println("Nome: " + found.getName());
                        System.out.println("Artista: " + found.getArtist().getName());
                        System.out.println("Gênero: " + found.getGenre().getName());
                        System.out.println("Duração: " + found.getDuration() + "s");
                    } else {
                        System.out.println("❌ Música não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Nome atual da música: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Novo nome da música: ");
                    String newName = scanner.nextLine();
                    boolean updated = musicController.update(oldName, newName);
                    System.out.println(updated ? "✅ Atualizada com sucesso!" : "❌ Música não encontrada.");
                    break;

                case 6:
                    System.out.print("Nome da música a deletar: ");
                    String musicToDelete = scanner.nextLine();
                    boolean deleted = musicController.delete(musicToDelete);
                    System.out.println(deleted ? "✅ Música deletada!" : "❌ Música não encontrada.");
                    break;

                case 7:
                    System.out.print("Email do artista: ");
                    String emailArtist = scanner.nextLine();
                    User artUser = userController.show(emailArtist);
                    if (artUser instanceof Artist) {
                        Artist a = (Artist) artUser;
                        a.showResourcesGranted();
                    } else {
                        System.out.println("❌ Artista não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("👋 Encerrando o sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Opção inválida.");
            }
        }
    }
}
