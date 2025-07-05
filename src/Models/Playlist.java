package Models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Music> music;

    public Playlist(String name) {
        this.name = name;
        this.music = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusicas() {
        return music;
    }

    public void setMusicas(Music musicas) {
        this.music.add(musicas);
    }
    public void showPlaylistInfo(){
        System.out.println("Name : "+name+"\n" +
                "length of playlist  : "+ music.toArray().length);
    }
    public void showPlaylistMusics(){
        for (Music music : this.music) {
            System.out.println("- " + music.name + "-"+ music.getGenre().name);
        }
    }
}
