```
classDiagram
    class Main

    class Artist {
        - List~Musica~ musicas
        +Artist(String name, String email, SubscriptionPlan subscription_type)
    }

    class Musica {
        - String name
        - Genero genero
        - int duration
        - Artist artist
        - List~Playlist~ playlists
    }

    class Genero {
        - String name
        +getName()
        +setName(String name)
    }

    class Playlist {
        - String name
        - List~Musica~ musicas
        +Playlist(String name)
    }

    class SubscriptionPlan {
        - String name
        - String price
        +getName()
        +setName(String name)
        +getPrice()
        +setPrice(String price)
    }

    class User {
        # String name
        # String email
        # SubscriptionPlan subscription_type
    }

    class User_Free {
        +showResourcesGranted()
    }

    class User_Premium {
        +showResourcesGranted()
    }

    %% Relações
    Artist --> User : extends
    User_Free --> User : extends
    User_Premium --> User : extends

    Musica --> Genero : has-a
    Musica --> Artist : has-a
    Musica --> Playlist : many-to-many
    Playlist --> Musica : has-many
    User --> SubscriptionPlan : has-a
```