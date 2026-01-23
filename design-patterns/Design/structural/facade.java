// FacadePatternHomeTheater.java
// Single-file Java example of Facade Pattern using Home Theater analogy

// Subsystem class 1
class DVDPlayer {
    void on() {
        System.out.println("DVD Player ON");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void off() {
        System.out.println("DVD Player OFF");
    }
}

// Subsystem class 2
class SoundSystem {
    void on() {
        System.out.println("Sound System ON");
    }

    void setVolume(int level) {
        System.out.println("Sound volume set to " + level);
    }

    void off() {
        System.out.println("Sound System OFF");
    }
}

// Subsystem class 3
class Projector {
    void on() {
        System.out.println("Projector ON");
    }

    void off() {
        System.out.println("Projector OFF");
    }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Projector projector;

    public HomeTheaterFacade() {
        dvdPlayer = new DVDPlayer();
        soundSystem = new SoundSystem();
        projector = new Projector();
    }

    public void watchMovie(String movie) {
        System.out.println("Starting movie...");
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down theater...");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
    }
}

// Client
public class facade {
    public static void main(String[] args) {

        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
