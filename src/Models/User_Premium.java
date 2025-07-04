package Models;

public class User_Premium extends User{

    public User_Premium(String name, String email,SubscriptionPlan subscription_type) {
        super(name, email, subscription_type);
    }

    @Override
    public void showResourcesGranted() {
        System.out.println("Congrats you are a Premium user , this is your privileges  : " +
                "\n -listen music [no restrictions :)]" +
                "\n -Save you loved playlists" +
                "\n -Save you amazing musics");
    }
}
