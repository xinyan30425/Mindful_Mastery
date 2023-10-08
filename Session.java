/** 
 * The Session class represents a session of exercise
 * 
 * @Author Xinyan Liu
 */

import java.util.ArrayList;
import java.util.List;

public class Session implements Subject{
    private String name;
    private String description;
    private int duration;
    private List<Exercise> exercises;
    private List<Observer> observers;

    /*
     * Constructor for the Session class
     * 
     * @param name the name of the session
     * @param description the description of the session
     * @param duration the duration of the session
     * @param exercises the exercises in the session
     */
    public Session(String name, String description, int duration, List<Exercise> exercises) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.exercises = exercises;
        observers = new ArrayList<Observer>();
    }

    /*
     * Registers an observer to the session
     * 
     * @param observer the observer to be registered
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /*
     * Removes an observer from the session
     * 
     * @param observer the observer to be removed
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

    /**
     * Adds a record to the session
     * 
     * @param record the record to be added
     */
    public void addRecord(SessionRecord record) {
    }

    /*
     * Return the name of the session
     * 
     * @return the name of the session
     */
    public String getName() {
        return name;
    }

    /*
     * Sets the name of the session
     * 
     * @param name the name of the session
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Returns the description of the session
     * 
     * @return the description of the session
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets the description of the session
     * 
     * @param description the description of the session
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Returns the duration of the session
     * 
     * @return the duration of the session
     */
    public int getDuration() {
        return duration;
    }

    /*
     * Sets the duration of the session
     * 
     * @param duration the duration of the session
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /*
     * Returns the exercises in the session
     * 
     * @return the exercises in the session
     */
    public List<Exercise> getExercises() {
        return exercises;
    }

    /*
     * Sets the exercises in the session
     * 
     * @param exercises the exercises in the session
     */
    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
