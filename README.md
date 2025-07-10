# **Java final assignment**

## 🎵 Java Music Streaming App

This project was developed as the final assignment for a university-level Java course, with the objective of applying key concepts of **Object-Oriented Programming (OOP)** in a functional application.

The challenge was to design and implement a complete system using Java, demonstrating a solid understanding of the main pillars of OOP: **encapsulation**, **inheritance**, **polymorphism**, and **abstraction**.

---

## 📌 Project Overview

The application simulates a **subscription-based music streaming service**, inspired by platforms like Spotify. The system includes basic but essential **CRUD (Create, Read, Update, Delete)** operations, allowing users and administrators to interact with the platform.

---

### 📚 Learning Goals

Practice and reinforce OOP concepts in a real-world inspired project

Build a modular and maintainable Java application

Understand how CRUD operations work in software systems

---

# **Mermaid**

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

# 📌 Project Structure

Current source directories and files from this project is consistent this :

```
.
├── out
│   └── production
│       └── untitled
│           ├── Controllers
│           │   ├── GenreController.class
│           │   ├── MusicController.class
│           │   ├── PlaylistController.class
│           │   ├── SubscriptionPlanController.class
│           │   └── UserController.class
│           ├── Main.class
│           ├── Models
│           │   ├── Artist.class
│           │   ├── Genre.class
│           │   ├── Music.class
│           │   ├── Playlist.class
│           │   ├── SubscriptionPlan.class
│           │   ├── User.class
│           │   ├── User_Free.class
│           │   └── User_Premium.class
│           ├── Runners
│           │   ├── RunnerGenre.class
│           │   ├── RunnerMusic.class
│           │   ├── RunnerPlaylist.class
│           │   ├── RunnerSubscriptionPlan.class
│           │   └── RunnerUser.class
│           └── Tests
│               ├── GenreTestMain.class
│               ├── MusicTestMain.class
│               ├── PlaylistTestMain.class
│               ├── SubscriptionPlanTestMain.class
│               └── UserTestMain.class
├── README.md
├── src
│   ├── Controllers
│   │   ├── GenreController.java
│   │   ├── MusicController.java
│   │   ├── PlaylistController.java
│   │   ├── SubscriptionPlanController.java
│   │   └── UserController.java
│   ├── Main.java
│   ├── Models
│   │   ├── Artist.java
│   │   ├── Genre.java
│   │   ├── Music.java
│   │   ├── Playlist.java
│   │   ├── SubscriptionPlan.java
│   │   ├── User_Free.java
│   │   ├── User.java
│   │   └── User_Premium.java
│   ├── Runners
│   │   ├── RunnerGenre.java
│   │   ├── RunnerMusic.java
│   │   ├── RunnerPlaylist.java
│   │   ├── RunnerSubscriptionPlan.java
│   │   └── RunnerUser.java
│   └── Tests
│       ├── GenreTestMain.java
│       ├── MusicTestMain.java
│       ├── PlaylistTestMain.java
│       ├── SubscriptionPlanTestMain.java
│       └── UserTestMain.java
└── untitled.iml

13 directories, 50 files
```

The source "Runners" only used for tests in developer mode