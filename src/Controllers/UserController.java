package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<>();

    public List<User> index(){
        return users; //Read
    }
    public void store(User user){
        users.add(user); //Create
        System.out.println("Usuário adicionado");
    }

    public User show(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null; // se não encontrar
    }

    public boolean update(String email, String name){
        User user = show(email);
        if(user != null){
            user.setName(name);
            return true;
        }
        return false;
    }


    public boolean delete(String email){
        User user = show(email);
        if(user != null){
            users.remove(user);
            return true;
        }
        return false;
    }


}
