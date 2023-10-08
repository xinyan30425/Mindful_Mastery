/**
 * This abstract class represents a linked list data structure for storing each exercise record.
 * 
 * @Author Xinyan Liu
 * 
 */

import java.util.Iterator;
import java.util.function.Predicate;


public abstract class ExerciseRecordList<T extends ExerciseRecord> implements Iterable<T>{
    protected Node<T> head;
    protected int size;

    /*
     * A reference to the head of the linked list.
     */
    public ExerciseRecordList(){
        head=null;
        size=0;
    }

    /*
     * Returns the number of nodes in the linked list.
     * @return the size of the linked list
     */
    public int size() {
        return size(head);
    }
    
    /*
     * Recursive method that computes the size of the linked list.
     * @param current A reference to the current node in the list.
     * @return the size of the linked list.
     */
    private int size(Node<T> current) {
        if (current == null) {
            return 0;
        }
        return 1 + size(current.next);
    }

    /*
     * Checks whether the linked list is empty
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Adds an exercise record to the end of the linked list
     * @param record The exercise record to add
     */
    public void add(ExerciseRecord record) {
        Node<ExerciseRecord> newNode = new Node<>(record);

        if (head == null) {
            head = (ExerciseRecordList.Node<T>) newNode;
        } else {
            Node<ExerciseRecord> current = (ExerciseRecordList.Node<ExerciseRecord>) head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }


    /*
     * Filters the linked list based on a specified predicate
     * @param predicate A predicate that specifies the condition for filtering 
     * @return an ExerciseRecordList object containing the filtered exercise records
     */
    public ExerciseRecordList<T> filter(Predicate<T> predicate) {
        ExerciseRecordList<T> result = createNewList();
        filter(head, predicate, result);
        return result;
    }

    /*
     * Abstract method that creates a new instance of the ExerciseRecordList subclass
     * @return a new instance of the ExerciseRecordList subclass
     */
    protected abstract ExerciseRecordList<T> createNewList();

   
    /*
     * recursive method that filters the linked list based on a specified predicate
     * 
     * @param current reference to the current node in the list
     * @param predicate that specifies the condition for filtering 
     * @param result: an ExerciseRecordList object to store the filtered exercise records
     */
    private void filter(Node<T> current, Predicate<T> predicate, ExerciseRecordList<T> result) {
        if (current == null) {
            return;
        }
        if (predicate.test(current.data)) {
            result.add(current.data);
        }
        filter(current.next, predicate, result);
    }
    
    /*
     * Abstract method that sorts the linked list
     */
    public abstract void sort();


    /*
     * Returns an iterator over the elements of the linked list
     * @return an iterator over the elements of the linked list
     */
    @Override
    public Iterator<T> iterator(){
        return new ExerciseRecordListIterator<>(head);
    }

    /*
     * Node class for a linked list, contains the data and a reference to the next node
     * @param <T> the type of data that the node holds
     */
    protected static class Node<T> {
        T data;
        Node<T> next;
        public ExerciseRecordList.Node<SessionRecord> prev;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /*
     * Iterator class for the linked list
     * @param <T> the type of data that the node holds
     */
    protected static class ExerciseRecordListIterator<T extends ExerciseRecord> implements Iterator<T> {
        private Node<T> current;

        public ExerciseRecordListIterator(Node<T> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
   
}
