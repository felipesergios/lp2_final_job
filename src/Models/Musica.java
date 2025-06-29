package Models;

public class Musica {
    String name;
    Genero genero;
    int duration;
    Artist artist;

    public Musica(String name, Genero genero, int duration, Artist artist) {
        this.name = name;
        this.genero = genero;
        this.duration = duration;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
