package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<>();

    public List<User> index(){
        return users; //Read
    }
    public User show(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Usuário com o email '" + email + "' não encontrado.");
    }

    public void store(User user) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new IllegalArgumentException("Usuário com este email já existe.");
            }
        }
        users.add(user);
    }


    public boolean update(String email, String name){
        User user = show(email);
        user.setName(email);
        return true;
    }


    public boolean delete(String email){
        User user = show(email);
        users.remove(user);
        return true;
    }


}
