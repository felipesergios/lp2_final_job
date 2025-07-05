package Models;

import java.util.ArrayList;
import java.util.List;

public class Artist extends User {
    private List<Music> music;
    public Artist(String name, String email, SubscriptionPlan subscription_type) {
        super(name, email, subscription_type);
        this.music = new ArrayList<>();
    }

    @Override
    public void showResourcesGranted() {
        System.out.println("Músicas cadastradas para o artista : ");
        for (Music music : this.music) {
            System.out.println("- " + music.name + "--"+ music.getGenre().name);
        }
    }

    public List<Music> getMusicas() {
        return music;
    }

    public void setMusicas(Music musicas) {
        this.music.add(musicas);
    }
}
