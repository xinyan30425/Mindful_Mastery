/**
 * An abstract class representing an exercise instance 
 * It implements the Subject interface to allow observers to subscribe and receive notifications of changes
 * 
 * @Author Xinyan Liu
 */


import java.util.ArrayList;
import java.util.List;

/*
 * public abstract class Exercise implements Subject
 */
public abstract class Exercise implements Subject{
    private String name;
    private String description;
    private int duration;
    private List<Observer> observers;

    /*
     * Constructer constructs a new Exercise object with the given name, description, and duration.
     *
     * @param name the name of the exercise
     * @param description the description of the exercise
     * @param duration the duration of the exercise
     */
    public Exercise(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        observers = new ArrayList<Observer>();
    }

    /*
     * Registers an observer to receive updates from this subject.
     * 
     * @param observer the observer to register
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /*
     * Removes an observer from receiving updates from this subject.
     * 
     * @param observer the observer to remove
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /*
     * Notifies all registered observers of updates.
     * 
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /*
     * Get the name of the exercise
     * 
     */
    public String getName() {
        return name;
    }

    /*
     * Get the description of the exercise
     */
    public String getDescription() {
        return description;
    }

    /*
     * Get the duration of the exercise
     */
    public int getDuration() {
        return duration;
    }

}


