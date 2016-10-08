package javase01.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A notepad of records. It provides one method for appending records,
 * two methods for removing and two for editing. Editing and removing
 * provide positional access but the <tt>Notepad</tt> class does not
 * allow you to add record to the specified position.
 */
public class Notepad {
    private List<Record> records;

    /**
     * Constructs an empty notepad.
     */
    public Notepad(){
        records = new ArrayList<>();
    }

    /**
     * Constructs a notepad containing the elements of the specified list.
     * @param records the list whose elements are to be placed into this notepad
     */
    public Notepad(List<Record> records){
        this.records = records;
    }

    /**
     * Inserts the specified record to the end of this notepad.
     * @param record record to be appended to this noteped
     * @return <tt>true</tt> (as specified by {@link List#add})
     */
    public boolean add(Record record){
        return records.add(record);
    }

    /**
     * Removes the record at the specified position in this notepad.
     * @param index the index of the record to be removed
     * @return the element that was removed from the list
     */
    public Record remove(int index){
        return records.remove(index);
    }

    /**
     * Removes the first occurrence of the specified record from this notepad, if it is present.
     * If the notepad doesn't contain the record it is unchanged.
     * @param record record to be removed from this notepad if it is present
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(Record record){
        return records.remove(record);
    }

    /**
     * Changes the record at the specified position to the given one
     * @param index the index of the record to be changed
     * @param newRec the record to be appended to this notepad at the specified index
     * @throws IndexOutOfBoundsException if the specified index is greater than a number of records in the notepad
     */
    public void edit(int index, Record newRec) throws IndexOutOfBoundsException{
        records.remove(index);
        records.add(index,newRec);
    }

    /**
     * Changes the first specified record to the second one
     * @param sourceRec the record to be changed
     * @param newRec the record to be appended to this notepad
     * @throws NoSuchElementException if the notepad does not contain the specified record
     */
    public void edit(Record sourceRec, Record newRec) throws NoSuchElementException{
        int index = records.indexOf(sourceRec);
        try {
            records.remove(index);
        }
        catch(IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
        records.add(index,newRec);
    }
}
