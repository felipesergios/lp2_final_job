package Tests;
import Controllers.MusicController;
import Controllers.PlaylistController;
import Controllers.UserController;
import Models.*;

import java.util.List;
import java.util.Scanner;

public class PlaylistTestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicController musicController = new MusicController();
        PlaylistController playlistController = new PlaylistController();
        UserController userController = new UserController();

        while (true) {
            System.out.println("\n--- MENU GERAL ---");
            System.out.println("1. Cadastrar artista");
            System.out.println("2. Cadastrar música");
            System.out.println("3. Listar músicas");
            System.out.println("4. Buscar música");
            System.out.println("5. Atualizar nome de música");
            System.out.println("6. Deletar música");
            System.out.println("7. Mostrar músicas de um artista");
            System.out.println("8. Criar nova playlist");
            System.out.println("9. Listar playlists");
            System.out.println("10. Buscar playlist por nome");
            System.out.println("11. Atualizar nome de playlist");
            System.out.println("12. Deletar playlist");
            System.out.println("13. Adicionar música à playlist");
            System.out.println("14. Mostrar músicas de uma playlist");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                // ARTISTAS
                case 1:
                    System.out.print("Nome do artista: ");
                    String name = scanner.nextLine();
                    System.out.print("Email do artista: ");
                    String email = scanner.nextLine();
                    System.out.print("Plano de assinatura (ex: PREMIUM, FREE): ");
                    String plan = scanner.nextLine().toUpperCase();

                    Artist artist = new Artist(name, email, new SubscriptionPlan(plan));
                    userController.store(artist);
                    System.out.println("✅ Artista cadastrado.");
                    break;

                // MÚSICAS
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
                        musicArtist.setMusicas(music); // adicionar ao artista
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

                // PLAYLISTS
                case 8:
                    System.out.print("Nome da nova playlist: ");
                    String playlistName = scanner.nextLine();
                    Playlist playlist = new Playlist(playlistName);
                    playlistController.store(playlist);
                    System.out.println("✅ Playlist criada.");
                    break;

                case 9:
                    List<Playlist> playlists = playlistController.index();
                    if (playlists.isEmpty()) {
                        System.out.println("Nenhuma playlist encontrada.");
                    } else {
                        for (Playlist p : playlists) {
                            p.showPlaylistInfo();
                        }
                    }
                    break;

                case 10:
                    System.out.print("Nome da playlist a buscar: ");
                    String searchName = scanner.nextLine();
                    Playlist foundPlaylist = playlistController.show(searchName);
                    if (foundPlaylist != null) {
                        foundPlaylist.showPlaylistInfo();
                    } else {
                        System.out.println("❌ Playlist não encontrada.");
                    }
                    break;

                case 11:
                    System.out.print("Nome atual da playlist: ");
                    String currentPlaylistName = scanner.nextLine();
                    System.out.print("Novo nome da playlist: ");
                    String newPlaylistName = scanner.nextLine();
                    boolean renamed = playlistController.update(currentPlaylistName, newPlaylistName);
                    System.out.println(renamed ? "✅ Nome atualizado!" : "❌ Playlist não encontrada.");
                    break;

                case 12:
                    System.out.print("Nome da playlist a deletar: ");
                    String deletePlaylist = scanner.nextLine();
                    boolean removed = playlistController.delete(deletePlaylist);
                    System.out.println(removed ? "✅ Playlist deletada!" : "❌ Playlist não encontrada.");
                    break;

                case 13:
                    System.out.print("Nome da playlist: ");
                    String plName = scanner.nextLine();
                    Playlist targetPlaylist = playlistController.show(plName);
                    if (targetPlaylist == null) {
                        System.out.println("❌ Playlist não encontrada.");
                        break;
                    }

                    System.out.print("Nome da música a adicionar: ");
                    String musicToAdd = scanner.nextLine();
                    Music music = musicController.show(musicToAdd);
                    if (music != null) {
                        targetPlaylist.setMusicas(music);
                        System.out.println("✅ Música adicionada à playlist.");
                    } else {
                        System.out.println("❌ Música não encontrada.");
                    }
                    break;

                case 14:
                    System.out.print("Nome da playlist: ");
                    String showPl = scanner.nextLine();
                    Playlist playlistToShow = playlistController.show(showPl);
                    if (playlistToShow != null) {
                        playlistToShow.showPlaylistMusics();
                    } else {
                        System.out.println("❌ Playlist não encontrada.");
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

