/**
 * This is the Course class, a course has a name, description, list of sessions, instructor, credits and a flag indicating if the course is required or not.
 * It also implements the Subject interface and allows observers to be registered, removed and notified when changes occur.
 * 
 * @Author Xinyan Liu
*/

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject{
    private String name;
    private String description;
    private List<Session> sessions;
    private Instructor instructor;
    private int credits;
    private boolean required;
    private List<Observer> observers;


    /*
     * Constructer constructs a new Course object with the given name, description, sessions, instructor, credits, and required status.
     *
     * @param name the name of the course
     * @param description the description of the course
     * @param sessions the list of sessions for the course
     * @param instructor the instructor for the course
     * @param credits the number of credits for the course
     * @param required whether the course is required or not
     */
    public Course(String name, String description, List<Session> sessions,Instructor instructor, int credits, boolean required) {
        this.name = name;
        this.description = description;
        this.sessions = sessions;
        this.instructor = instructor;
        this.credits = credits;
        this.required = required;
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
     * Gets the name of the course.
     * 
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /*
     * Sets the name of the course.
     * 
     * @param name the name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Gets the description of the course.
     * 
     * @return the description of the course
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets the description of the course.
     * 
     * @param description the description of the course
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Gets the list of sessions for the course.
     * 
     * @return the list of sessions for the course
     */
    public List<Session> getSessions() {
        return sessions;
    }


    /*
     * Sets the list of sessions for the course.
     * 
     * @param sessions the list of sessions for the course
     */
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    /*
     * Gets the instructor for the course.
     * 
     * @return the instructor for the course
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /*
     * Sets the instructor for the course.
     * 
     * @param instructor the instructor for the course
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /*
     * Gets the number of credits for the course.
     * 
     * @return the number of credits for the course
     */
    public int getCredits() {
        return credits;
    }

    /*
     * Sets the number of credits for the course.
     * 
     * @param credits the number of credits for the course
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /*
     * Gets whether the course is required or not.
     * 
     * @return whether the course is required or not
     */
    public boolean isRequired() {
        return required;
    }

    /*
     * Sets whether the course is required or not.
     * 
     * @param required whether the course is required or not
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

}
