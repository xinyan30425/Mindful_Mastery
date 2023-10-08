/**
 * The NotificationSystem for new courses being added to a list of courses
 * 
 * @Author Xinyan Liu
 */

import java.util.ArrayList;
import java.util.List;


public class NotificationSystem{
    private List<Course> courses;
    private List<Observer> observers;

    /*
     * Constructs a NotificationSystem object with an empty list of courses and an empty list of observers.
     */
    public NotificationSystem() {
        this.courses = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /*
     * Adds an observer to the list of observers
     * @param observer an Observer object to be added to the list of observers
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /*
     * Removes an observer from the list of observers
     * @param observer an Observer object to be removed from the list of observers
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /*
     * Adds a new course to the list of courses and notifies all observers
     * @param course a Course object to be added to the list of courses
     */
    public void addCourse(Course course) {
        this.courses.add(course);
        notifyObservers(course);
    }

    /*
     * Notifies all observers that a new course has been added to the list of courses
     * @param course a Course object that has been added to the list of courses
     */
    void notifyObservers(Course course) {
        System.out.println("New course available! New course added: " + course.getName());
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /*
     * Returns the list of courses
     * @return the list of courses
     */
    public List<Course> getCourses() {
        return this.courses;
    }
    
}
