package Models;

public class Musica {
    String name;
    Genero genero;
    int duration;

    public Musica(String name, Genero genero, int duration) {
        this.name = name;
        this.genero = genero;
        this.duration = duration;
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
}
