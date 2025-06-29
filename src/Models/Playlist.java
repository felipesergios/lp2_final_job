package Models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Musica> musicas;

    public Playlist(String name) {
        this.name = name;
        this.musicas = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Musica musicas) {
        this.musicas.add(musicas);
    }
    public void showPlaylistInfo(){
        System.out.println("Playlist : "+name+"\n" +
                "Lenght of Musics : "+musicas.toArray().length);
    }
    public void showPlaylistMusics(){
        for (Musica musica : musicas) {
            System.out.println("- " + musica.name + "-"+musica.getGenero().name);
        }
    }
}
