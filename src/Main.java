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
        g2.setName("RAP"); // Try Update Method




        Artist artist1 = new Artist("Angra","angra@mail.com",Plan1);
        Musica m1 = new Musica("Highway",g2,3,artist1);
        Musica m2 = new Musica("Carry On",g2,3,artist1);
        Musica m3 = new Musica("All eyes on Me ",g2,3,artist1);
        artist1.setMusicas(m1);
        artist1.setMusicas(m2);
        artist1.showResourcesGranted();

        User u1 = new User_Free("Jose","jose@google.com",Plan1);
        User u2 = new User_Premium("Carlos","carlos@google.com",Plan2);

        u2.showUserInfo();
        u2.showResourcesGranted();

        Playlist play_1 = new Playlist("Musicas para treinar");
        Playlist play_2 = new Playlist("Musicas para GYM");
        play_1.setMusicas(m1);
        play_1.setMusicas(m2);
        play_2.setMusicas(m1);
        play_2.setMusicas(m2);
        play_2.setMusicas(m3);
        m1.setPlaylists(play_1);
        m2.setPlaylists(play_1);
        m2.setPlaylists(play_2);
        m3.setPlaylists(play_2);

        play_1.setName("Musicas para treinar");
        play_1.showPlaylistInfo();
        play_1.showPlaylistMusics();

        System.out.println("Mostrando Quais são as playlist que cada musica esta presente");

        m2.showPlaylistWhereMusicisPresent();

    }
}