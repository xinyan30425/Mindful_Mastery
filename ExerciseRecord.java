/**
 * This is an abstract class and it can be extended by specific types of records
 * It has the properties for the start time, duration of an exercise session
 * 
 * @Author Xinyan Liu
 */

import java.time.LocalDateTime;

public abstract class ExerciseRecord {
    private LocalDateTime startTime;
    private int duration;
    private Meditation meditation;

    /*
     * Constructor for creating a new ExerciseRecord object with the given start time, duration, and meditation
     * 
     * @param startTime the start time of the exercise session
     * @param duration the duration of the exercise session in minutes
     * @param meditation the meditation used during the exercise session
     */

    public ExerciseRecord(LocalDateTime startTime, int duration,Meditation meditation) {
        this.startTime = startTime;
        this.duration = duration;
        this.meditation = meditation;
    }


    /*
     * Gets the start time of the exercise session
     * 
     * @return the start time of the exercise session
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /*
     * Gets the duration of the exercise session
     * 
     * @return the duration of the exercise session
     */
    public int getDuration() {
        return duration;
    }


    /*
     * Gets the meditation used during the exercise session
     * 
     * @return the meditation used during the exercise session
     */
    public Meditation getMeditation() {
        return meditation;
    }

    /*
     * Sets the meditation used during the exercise session
     * 
     * @param meditation the meditation used during the exercise session
     */
    public void setMeditation(Meditation meditation) {
        this.meditation = meditation;
    }
}
