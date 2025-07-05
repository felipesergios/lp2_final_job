package Models;

import java.util.ArrayList;
import java.util.List;

public class Artist extends User {
    private List<Musica> musicas;
    public Artist(String name, String email, SubscriptionPlan subscription_type) {
        super(name, email, subscription_type);
        this.musicas = new ArrayList<>();
    }

    @Override
    public void showResourcesGranted() {
        System.out.println("Músicas cadastradas para o artista : ");
        for (Musica musica : musicas) {
            System.out.println("- " + musica.name + "--"+musica.getGenre().name);
        }
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Musica musicas) {
        this.musicas.add(musicas);
    }
}
