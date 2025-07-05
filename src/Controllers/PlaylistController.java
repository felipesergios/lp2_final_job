package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class PlaylistController {
    private List<Playlist> playlists = new ArrayList<>();
    public List<Playlist> index(){return playlists;}
    public void store(Playlist playlist){playlists.add(playlist);}
    public Playlist show(String name){
        for(Playlist playlist : playlists){
            if(playlist.getName().equalsIgnoreCase(name)){
                return playlist;
            }
        }
        return null;
    }
    public boolean update(String name, String newName){
        Playlist playlist = show(name);
        if(playlist != null){
            playlist.setName(newName);
            return true;
        }
        return false;
    }
    public boolean delete(String name){
        Playlist playlist = show(name);
        if(playlist != null){playlists.remove(playlist);return true;}
        return false;
    }
}
