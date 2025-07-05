package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class MusicController {
    private List<Music> songs = new ArrayList<>();
    public List<Music> index(){return songs;}
    public void store(Music music){songs.add(music);}
    public Music show(String name){
        for (Music music : songs){
            if(music.getName().equalsIgnoreCase(name)){
                return music;
            }
        }
        return null;
    }
    public boolean update(String name,String newName){
        Music music = show(name);
        if(music != null){music.setName(newName);return true;}
        return false;
    }
    public boolean delete(String name){
        Music music = show(name);
        if(music != null){
            songs.remove(music);
            return true;
        }
        return false;
    }
}
