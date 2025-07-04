package Models;

public abstract class User {
    protected String name;
    protected String email;
    protected SubscriptionPlan subscription_type; // Relationship 1:1 - One User have one plain

    public User(String name, String email, SubscriptionPlan subscription_type) {
        this.name = name;
        this.email = email;
        this.subscription_type = subscription_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SubscriptionPlan getSubscription_type() {
        return subscription_type;
    }

    public void setSubscription_type(SubscriptionPlan subscription_type) {
        this.subscription_type = subscription_type;
    }

    public void showUserInfo(){
        System.out.println("Fully Name : "+name+"\nE-mail : "+email+"Plan Type:"+subscription_type.getName()+"\n");
    }
    public abstract void showResourcesGranted();
}
