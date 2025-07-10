package Runners;

import Controllers.PlaylistController;
import Models.Playlist;

import java.util.Scanner;

public class RunnerPlaylist {
    public static void main(PlaylistController playlistController) {
        Scanner scanner = new Scanner(System.in);
        int selector;

        do {
            System.out.println("===SUB-PROGRAMA-ADM-PLAYLISTS-===" +
                    "\n1.->ADICIONAR NOVA PLAYLIST" +
                    "\n2.->LISTAR TODAS AS PLAYLISTS" +
                    "\n3.->ATUALIZAR NOME DE PLAYLIST" +
                    "\n4.->REMOVER PLAYLIST" +
                    "\n5.->MOSTRAR DETALHES DE UMA PLAYLIST" +
                    "\n0.->SAIR DO SUBPROGRAMA E VOLTAR AO MENU INICIAL");

            selector = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (selector) {
                case 1:
                    System.out.println("Informe o nome da nova playlist:");
                    String name = scanner.nextLine();

                    try {
                        Playlist playlist = new Playlist(name);
                        playlistController.store(playlist);
                        System.out.println("Playlist cadastrada com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar playlist: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao cadastrar playlist. Detalhes: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Listando todas as playlists:");
                    for (Playlist p : playlistController.index()) {
                        System.out.println("- " + p.getName());
                    }
                    break;

                case 3:
                    System.out.println("Informe o nome atual da playlist:");
                    String oldName = scanner.nextLine();
                    System.out.println("Informe o novo nome da playlist:");
                    String newName = scanner.nextLine();

                    try {
                        if (playlistController.update(oldName, newName)) {
                            System.out.println("Playlist atualizada com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao atualizar playlist. Detalhes: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Informe o nome da playlist a ser deletada:");
                    String nameToDelete = scanner.nextLine();

                    try {
                        if (playlistController.delete(nameToDelete)) {
                            System.out.println("Playlist deletada com sucesso.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao deletar playlist. Detalhes: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Informe o nome da playlist para exibir os detalhes:");
                    String nameToShow = scanner.nextLine();

                    try {
                        Playlist p = playlistController.show(nameToShow);
                        p.showPlaylistInfo();
                        System.out.println("Músicas da Playlist:");
                        p.showPlaylistMusics();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado ao exibir playlist. Detalhes: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (selector != 0);
    }
}
