package Runners;

import Controllers.MusicController;
import Controllers.PlaylistController;
import Controllers.UserController;
import Models.*;

import java.util.Scanner;

public class RunnerMusic {
    public static void main(MusicController musicController, UserController userController , PlaylistController playlistController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-MÚSICAS===" +
                    "\n1.->ADICIONAR NOVA MÚSICA" +
                    "\n2.->LISTAR MÚSICAS" +
                    "\n3.->ATUALIZAR UMA MÚSICA" +
                    "\n4.->REMOVER UMA MÚSICA" +
                    "\n5.->MOSTRAR PLAYLISTS DE UMA MÚSICA" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");
            selector = scanner.nextInt();
            scanner.nextLine();

            switch (selector) {
                case 1:
                    // Adicionar nova música
                    System.out.println("Informe o nome da música:");
                    String musicName = scanner.nextLine();
                    System.out.println("Informe o gênero da música:");
                    String genreName = scanner.nextLine();
                    Genre genre = new Genre(genreName);
                    System.out.println("Informe a duração da música (em segundos):");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o e-mail do artista:");
                    String artistName = scanner.nextLine();
                    System.out.println("Quer adicionar essa música a alguma playlist agora ? \nS/N ?");
                    String reply = scanner.nextLine();
                    String playlist_name = null;

                    if (reply.equalsIgnoreCase("s")) {
                        System.out.println("Informe o nome da playlist : \n");
                        playlist_name = scanner.nextLine();
                    }

                    User search_user = userController.show(artistName);
                    Artist artist = new Artist(search_user.getName(), search_user.getEmail(), search_user.getSubscription_type());
                    Music music = new Music(musicName, genre, duration, artist);
                    music.setPlaylists(playlistController.show(playlist_name)); //link playlist to music [1:1] (N:M)

                    try {

                        musicController.store(music);
                        System.out.println("Música cadastrada com sucesso!");


                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar música: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao cadastrar música. Detalhes: " + e.getMessage());
                    }

                    try{
                        Playlist playlist = playlistController.show(playlist_name);
                        playlist.setMusicas(music);
                    }catch (IllegalArgumentException e){
                        System.out.println("Erro inesperado ao vincular a musica com a playlist :"+e.getMessage());
                    }


                    break;

                case 2:
                    // Listar músicas cadastradas
                    try {
                        System.out.println("Músicas cadastradas:");
                        for (Music data : musicController.index()) {
                            System.out.println("#==> " + data.getName() + " <==");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar músicas: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Atualizar música
                    System.out.print("Digite o nome atual da música: ");
                    String currentMusicName = scanner.nextLine();
                    System.out.print("Digite o novo nome da música: ");
                    String newMusicName = scanner.nextLine();

                    try {
                        boolean updated = musicController.update(currentMusicName, newMusicName);
                        if (updated) {
                            System.out.println("Música atualizada com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao atualizar música. Detalhes: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Remover música
                    System.out.print("Digite o nome da música que deseja remover: ");
                    String musicToDelete = scanner.nextLine();

                    try {
                        boolean deleted = musicController.delete(musicToDelete);
                        if (deleted) {
                            System.out.println("Música removida com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao remover música. Detalhes: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Mostrar playlists de uma música
                    System.out.print("Digite o nome da música para ver suas playlists: ");
                    String musicNameForPlaylist = scanner.nextLine();

                    try {
                        Music musicForPlaylist = musicController.show(musicNameForPlaylist);
                        musicForPlaylist.showPlaylistWhereMusicisPresent();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao listar playlists. Detalhes: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do subprograma...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (selector != 0);
    }
}
