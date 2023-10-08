/**
 * MeditationRecord class extends the ExerciseRecord abstract class and inherit the basic properties to represent a single meditation session
 * 
 * @Author Xinyan Liu
 */

import java.time.LocalDateTime;

public class MeditationRecord extends ExerciseRecord {
    private Meditation meditation;
    private String emotionalState;

    /*
     *Constructor for MeditationRecord class.
     *@param startTime The start time of the meditation session.
     *@param duration The duration of the meditation session.
     *@param meditation The meditation object associated with the session.
     */
    public MeditationRecord(LocalDateTime startTime, int duration,Meditation meditation) {
        super(startTime,duration,meditation);
        this.meditation = meditation;

    }

    /*
     *Get the name of the associated meditation object.
     *@return The name of the meditation.
     */
    public String getName() {
        return meditation.getName();
    }

    /*
     *Get the duration of the associated meditation object.
     *@return the duration of the meditation.
     */
    public int getDuration() {
        return meditation.getDuration();
    }

    /*
     *Set the emotional status of the associated meditation object.
     *@return the emotional status of the meditation.
     */
    public void setEmotionalState(String emotionalState) {
        this.emotionalState = emotionalState;
    }

    /*
     *Get the emotional status of the associated meditation object.
     *@return the emotional status of the meditation.
     */
    public String getEmotionalState() {
        return emotionalState;
    }

}