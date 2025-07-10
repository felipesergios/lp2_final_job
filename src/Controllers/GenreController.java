package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class GenreController {
    private List<Genre> genres = new ArrayList<>();

    public List<Genre> index(){return genres;};

    public void store(Genre genre){
        for(Genre data : genres){
            if(data.getName().equalsIgnoreCase(genre.getName())){
                throw new IllegalArgumentException("Genero com o nome '" + genre.getName() + "' já existe na base!.");
            }
        }
        genres.add(genre);
    }

    public Genre show(String name){
        for(Genre genre : genres){
            if(genre.getName().equalsIgnoreCase(name)){return genre;}
        }
        throw new IllegalArgumentException("Genero '" + name + "' Não foi encontrado !! ");
    }
    public boolean update(String name,String newName){
        Genre genre = show(name);
        genre.setName(newName);
        return true;
    }
    public boolean delete(String name){
        Genre genre = show(name);
        genres.remove(genre);
        return true;
    }
}
