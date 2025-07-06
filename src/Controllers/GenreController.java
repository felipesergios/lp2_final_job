package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class GenreController {
    private List<Genre> genres = new ArrayList<>();

    public List<Genre> index(){return genres;};

    public void store(Genre genre){genres.add(genre);};

    public Genre show(String name){
        for(Genre genre : genres){
            if(genre.getName().equalsIgnoreCase(name)){return genre;}
        }
        return null;
    }
    public boolean update(String name,String newName){
        Genre genre = show(name);
        if(genre != null){genre.setName(newName);return true;}
        return false;
    }
    public boolean delete(String name){
        Genre genre = show(name);
        if (genre != null){genres.remove(genre);return true;}
        return false;
    }

}
