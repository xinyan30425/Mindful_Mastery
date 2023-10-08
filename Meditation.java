/**
 * This Meditation class extends Exercise class and implements ExerciseInterface
 * It keeps tracks of the meditation's instructor, session, course, start time, end time, current duration, pause or stop
 * also has a list of meditation records associated with it
 * 
 * @Author Xinyan Liu
 * 
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Meditation extends Exercise implements ExerciseInterface {
    private Instructor instructor;
    private Session session;
    private Course course;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPaused;
    private int currentDuration;
    List<MeditationRecord> records;

    /*
     * Constructor for the Meditation class
     * 
     * @param name the name of the meditation exercise
     * @param description the description of the meditation exercise
     * @param duration the duration of the meditation exercise
     * @param instructor the instructor of the meditation exercise
     */
    public Meditation(String name, String description, int duration, Instructor instructor) {
        super(name, description, duration);
        this.instructor = instructor;
        this.records = new ArrayList<>();

    }

    /*
     * Starts the meditation exercise
     */
    public void start() {
        startTime = LocalDateTime.now();
        isPaused = false;
        currentDuration = 0;
    }

    /*
     * Pause the meditation exercise
     */
    public void pause() {
        if (!isPaused) {
            isPaused = true;
            endTime = LocalDateTime.now();
            currentDuration += Duration.between(startTime, endTime).toSeconds();
        }
    }

    /*
     * Resumes the meditation exercise
     */
    public void resume() {
        if (isPaused) {
            isPaused = false;
            startTime = LocalDateTime.now();
        }
    }

    /*
     * Stops the meditation
     */
    public void stop() {
        if (!isPaused) {
            endTime = LocalDateTime.now();
            currentDuration += Duration.between(startTime, endTime).toSeconds();
        }
    }

    /*
     * Returns the instructor of the meditation exercise
     * 
     * @return the instructor of the meditation exercise
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /*
     * Returns the session of the meditation exercise
     * 
     * @return the session of the meditation exercise
     */
    public Session getSession() {
        return session;
    }

    /*
     * Returns the course of the meditation exercise
     * 
     * @return the course of the meditation exercise
     */
    public Course getCourse() {
        return course;
    }

    /*
     * Adds a meditation record to the list of meditation records associated with the meditation exercise
     * 
     * @param record the meditation record to add
     * @throws IllegalArgumentException if the record is null
     */
    public void addRecord(MeditationRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }
        this.records.add(record);
    }

}
