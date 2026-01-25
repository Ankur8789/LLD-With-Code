/*
OBSERVER DESIGN PATTERN – SINGLE FILE EXPLANATION

Scenario:
A YouTube channel uploads videos.
Subscribers want to be notified automatically when a new video is uploaded.
*/

import java.util.*;

// -------------------- OBSERVER --------------------
/*
Observer interface.
Any class that wants updates MUST implement this.
*/
interface Observer {
    void update(String videoTitle);
}

// -------------------- SUBJECT --------------------
/*
Subject interface.
Defines methods to add/remove/notify observers.
*/
interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}

// -------------------- CONCRETE SUBJECT --------------------
/*
YouTubeChannel is the Subject.
It keeps track of subscribers and notifies them when state changes.
*/
class YouTubeChannel implements Subject {

    private List<Observer> subscribers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer sub : subscribers) {
            sub.update(latestVideo);
        }
    }

    // Business logic method
    public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println("\n📢 Channel uploaded new video: " + title);
        notifyObservers();
    }
}

// -------------------- CONCRETE OBSERVER --------------------
/*
Subscriber reacts to updates.
Each subscriber may react differently.
*/
class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("🔔 " + name + " notified about video: " + videoTitle);
    }
}

// -------------------- CLIENT --------------------
/*
Main class that wires everything together.
*/
public class ObserverPatternDemo {

    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Observer user1 = new Subscriber("Ankur");
        Observer user2 = new Subscriber("Rahul");
        Observer user3 = new Subscriber("Sneha");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Observer Pattern Explained");

        channel.subscribe(user3);

        channel.uploadVideo("Decorator Pattern Deep Dive");

        channel.unsubscribe(user2);

        channel.uploadVideo("Proxy Pattern in Java");
    }
}
