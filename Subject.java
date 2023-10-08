/**
 * Subject interface with methods to register, remove, and notify observers
 * 
 * @Author Xinyan Liu
 */

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}