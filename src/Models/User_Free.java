package Models;

public class User_Free extends User{
    public User_Free(String name, String email ,SubscriptionPlan subscription_type) {
        super(name, email, subscription_type);

    }

    @Override
    public void showResourcesGranted() {
        System.out.println("You Can  : listen music with annoucies only");
    }
}
