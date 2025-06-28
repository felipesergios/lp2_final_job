package Models;

public abstract class User {
    protected String name;
    protected String email;
    protected SubscriptionPlan subscription_type;

    public User(String name, String email, SubscriptionPlan subscription_type) {
        this.name = name;
        this.email = email;
        this.subscription_type = subscription_type;
    }
    public void showUserInfo(){
        System.out.println("Fully Name : "+name+"\nE-mail : "+email+"Plan Type:"+subscription_type.getName()+"\n");
    }
    public abstract void showResourcesGranted();
}
