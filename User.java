/**
 * User class stores the MeditationRecords and SessionRecord objects
 * 
 * @Author Xinyan Liu
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


public class User implements Observer{
    private String name;
    private String email;
    private String password;
    private int duration;
    private Collection<MeditationRecord> meditationHistory;
    private Collection<SessionRecord> sessionHistory;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.meditationHistory = new ArrayList<>();
        this.sessionHistory = new ArrayList<>();
    }
    
    /*
     * Prints a notification message to the console indicating that a user has been notified
     */
    @Override
    public void update() {
        System.out.println("User " + this.name + " has been notified");
    }

    /*
     * Registers the user as an observer with the provided NotificationSystem object.
     * @param notificationSystem the NotificationSystem object to register with
     */
    public void register(NotificationSystem notificationSystem) {
        notificationSystem.addObserver(this);
    }

    /*
     * Unregisters the user as an observer with the provided NotificationSystem object.
     * @param notificationSystem the NotificationSystem object to unregister with
     */
    public void unregister(NotificationSystem notificationSystem) {
        notificationSystem.removeObserver(this);
    }

    /*
     * Sets the name of the user.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Sets the email of the user.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Sets the password of the user.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * Returns the name of the user.
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /*
     * Returns the email of the user.
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /*
     * Returns the password of the user.
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /*
     * Returns true if the provided password matches the user's password, false otherwise.
     * @param password the password to check
     * @return true if the provided password matches the user's password, false otherwise
     */
    public boolean login(String password) {
        return this.password.equals(password);
    }

    /*
     * Logs the user out of the system.
     */
    public void logout() {
      
    }


    /*
     * Updates the user's meditation history with a new record.
     * @param meditation the Meditation object associated with the record
     * @param startTime the start time of the meditation
     * @param minutes the duration of the meditation in minutes
     */
    public void updateMeditationHistory(Meditation meditation, LocalDateTime startTime, int minutes,String emotionalState) {
        MeditationRecord record = new MeditationRecord(startTime, duration, meditation);
        meditation.addRecord(record);
        record.setEmotionalState(emotionalState);
        this.meditationHistory.add(record);
        
    }
    
    /*
     * Updates the user's session history with a new record.
     * @param session the Session object associated with the record
     * @param startTime the start time of the session
     * @param endTime the end time of the session
     */
    public void updateSessionHistory(Session session, LocalDateTime startTime, LocalDateTime endTime) {
        SessionRecord record = new SessionRecord(startTime, endTime, session);
        session.addRecord(record);
        this.sessionHistory.add(record);
    }

    /*
     * Returns the user's meditation history.
     * @return the user's meditation history
     */
    public Collection<MeditationRecord> getMeditationHistory() {
        return meditationHistory;
    }

    /*
     * Returns the user's session history.
     * @return the user's session history
     */
    public Collection<SessionRecord> getSessionHistory() {
        return sessionHistory;
    }

    /*
     * Returns the total number of minutes the user has meditated.
     * @return the total number of minutes the user has meditated
     */
    public int getTotalMeditationTime() {
        int totalTime = 0;
        for (MeditationRecord record : meditationHistory) {
            totalTime += record.getDuration();
        }
        return totalTime;
    }



}
