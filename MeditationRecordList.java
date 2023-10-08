/**
 * This is an implementation of a linked list data structure abstract class for storing each exercise records
 * 
 * @Author Xinyan Liu
 */


import java.util.function.Predicate;

public class MeditationRecordList extends ExerciseRecordList<MeditationRecord> {
    public MeditationRecordList() {
        super();
    }

    /*
     * Filters the meditation record list based on the given predicate
     * @param predicate the predicate used to filter the meditation record list
     * @return a new MeditationRecordList that contains only the meditation records that match the given predicate
     */
    @Override
    public MeditationRecordList filter(Predicate<MeditationRecord> predicate) {
        return (MeditationRecordList) super.filter(predicate);
    }
    
    /*
     * Bubble sort method sorts the list in ascending order of duration or date
     * iterates over the list using two nested loops
     * Comparing adjacent elements and swap them if they are out of order
     * The outer loop continues until the list is sorted
     */
    @Override
    public void sort() {
        //Bubble sort
        boolean sorted = false;
        Node<MeditationRecord> current;
        Node<MeditationRecord> next;

        while (!sorted) {
            sorted = true;
            current = head;
            next = head.next;

            while (next != null) {
                if (current.data.getDuration() > next.data.getDuration()) {
                    // Swap the nodes
                    MeditationRecord temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                    sorted = false;
                }
                current = current.next;
                next = next.next;
            }
        }
    }

    /*
     * Creates and returns a new MeditationRecordList instance
     * 
     * @return a new MeditationRecordList instance
     */
    @Override
    public ExerciseRecordList<MeditationRecord> createNewList() {
        return new MeditationRecordList();
    }

}

