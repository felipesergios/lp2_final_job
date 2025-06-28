import Models.SubscriptionPlan;
import Models.User;
import Models.User_Free;
import Models.User_Premium;
public class Main {
    public static void main(String[] args) {
        SubscriptionPlan Plan1 = new SubscriptionPlan();
        SubscriptionPlan Plan2 = new SubscriptionPlan();
        Plan1.setName("FREE");
        Plan1.setPrice("00.00");
        Plan2.setName("Premium");
        Plan2.setPrice("19.90");

        User u1 = new User_Free("Jose","jose@google.com",Plan1);
        User u2 = new User_Premium("Carlos","carlos@google.com",Plan2);

        u2.showUserInfo();
        u2.showResourcesGranted();
    }
}