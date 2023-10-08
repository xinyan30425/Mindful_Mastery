/**
 * This is an implementation of a linked list data structure abstract class for storing each exercise records
 * 
 * @Author Xinyan Liu
 */

import java.util.function.Predicate;

public class SessionRecordList extends ExerciseRecordList<SessionRecord>{
    /*
     * Constructor for creating a new empty SessionRecordList.
     */
    public SessionRecordList(){
        super();
    }
    /*
     * Returns the total duration of all session records in the list.
     * @return the total duration of all session records in the list
     */
    public int getTotalDuration() {
        int totalDuration = 0;
        for (SessionRecord record : this) {
            totalDuration += record.getDuration();
        }
        return totalDuration;
    }

    /*
     * Filters the session record list based on the given predicate.
     * @param predicate the predicate used to filter the session record list
     * @return a new SessionRecordList that contains only the session records that match the given predicate
     */
    public SessionRecordList filter(Predicate<SessionRecord> predicate) {
        return (SessionRecordList) super.filter(predicate);
    }

    /*
     * Sorts the session record list using the insertion sort algorithm.
     * Overrides the sort method from the ExerciseRecordList class.
     */
    @Override
    public void sort() {
        //
        Node<SessionRecord> current = head.next;
        while (current != null){
            SessionRecord currentData = current.data;
            Node <SessionRecord> prev = current.prev;

            while (prev != null && prev.data.getDuration() > currentData.getDuration()){
                prev.next.data = prev.data;
                prev = prev.prev;
            }

            if(prev == null){
                head.data = currentData;
            }
            else {
                prev.next.data = currentData;
            }

            current = current.next;
        }
    }
   
    /*
     * Creates a new SessionRecordList.
     * Overrides the createNewList method from the ExerciseRecordList class.
     * @return a new SessionRecordList
     */
    @Override
    public ExerciseRecordList<SessionRecord> createNewList() {
        return new SessionRecordList();
    }
}
