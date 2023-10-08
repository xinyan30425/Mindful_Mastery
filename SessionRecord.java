/**
 * SessionRecord extend the abstract class ExerciseRecord
 * Add an additional "endTime" property 
 * 
 *
 * @Author Xinyan Liu
 */

import java.time.Duration;
import java.time.LocalDateTime;

public class SessionRecord extends ExerciseRecord{
    private LocalDateTime endTime;
    private Session session;
   
    /**
     * Constructs a new SessionRecord object with the given parameters.
     * 
     * @param startTime the start time of the session
     * @param endTime the end time of the session
     * @param session the session object to which this record belongs
     */
    public SessionRecord(LocalDateTime startTime, LocalDateTime endTime, Session session) {
        super(startTime, (int) Duration.between(startTime, endTime).getSeconds(), null);
        this.endTime = endTime;
        this.session = session;
    }

    /**
     * Gets the end time of the session
     * 
     * @return the end time of the session
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Gets the session object to which this record belongs
     * 
     * @return the session object to which this record belongs
     */
    public Session getSession() {
        return session;
    }

    /**
     * Sets the session object to which this record belongs
     * 
     * @return the session object to which this record belongs
     */
    public void setSession(Session session) {
        this.session = session;
    }
}