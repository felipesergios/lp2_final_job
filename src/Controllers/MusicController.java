package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class MusicController {
    private List<Music> songs = new ArrayList<>();

    public List<Music> index(){return songs;}

    public void store(Music music){
        for(Music data : songs){
            if(data.getName().equalsIgnoreCase(music.getName())){
                throw new IllegalArgumentException("A "+music.getName()+" Já existe na base !");
            }
        }
        songs.add(music);
    }

    public Music show(String name){
        for (Music music : songs){
            if(music.getName().equalsIgnoreCase(name)){
                return music;
            }
        }
        throw new IllegalArgumentException("Não foi possível encontrar a musica : "+name+"  na base.");
    }

    public boolean update(String name,String newName){
        Music music = show(name);
        music.setName(newName);
        return true;
    }
    public boolean delete(String name){
        Music music = show(name);
        songs.remove(music);
        return true;
    }
}
