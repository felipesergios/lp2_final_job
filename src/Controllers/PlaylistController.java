package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;
public class PlaylistController {
    private List<Playlist> playlists = new ArrayList<>();

    public List<Playlist> index(){return playlists;}

    public void store(Playlist playlist){
        for (Playlist data : playlists){
            if(data.getName().equalsIgnoreCase(playlist.getName())){
                throw new IllegalArgumentException("A Playlist com o nome '" + playlist.getName() + "' já existe na base !!!.");
            }
        }
        playlists.add(playlist);
    }


    public Playlist show(String name){
        for(Playlist playlist : playlists){
            if(playlist.getName().equalsIgnoreCase(name)){
                return playlist;
            }
        }
        throw new IllegalArgumentException("A Playlist com o nome '" + name + "' não foi encontrada.");
    }

    public boolean update(String name, String newName){
        Playlist playlist = show(name);
        playlist.setName(newName);
        return true;
    }
    public boolean delete(String name){
        Playlist playlist = show(name);
        playlists.remove(playlist);
        return true;
    }
}
