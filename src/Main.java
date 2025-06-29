import Models.*;

public class Main {
    public static void main(String[] args) {
        SubscriptionPlan Plan1 = new SubscriptionPlan();
        SubscriptionPlan Plan2 = new SubscriptionPlan();
        Plan1.setName("FREE");
        Plan1.setPrice("00.00");
        Plan2.setName("Premium");
        Plan2.setPrice("19.90");
        Genero g1 = new Genero();
        Genero g2 = new Genero();
        g1.setName("Folk");
        g2.setName("Rock");




        Artist artist1 = new Artist("Angra","angra@mail.com",Plan1);
        Musica m1 = new Musica("Highway",g2,3,artist1);
        Musica m2 = new Musica("Carry On",g2,3,artist1);
        artist1.setMusicas(m1);
        artist1.setMusicas(m2);
        artist1.showResourcesGranted();

        User u1 = new User_Free("Jose","jose@google.com",Plan1);
        User u2 = new User_Premium("Carlos","carlos@google.com",Plan2);

        u2.showUserInfo();
        u2.showResourcesGranted();
    }
}