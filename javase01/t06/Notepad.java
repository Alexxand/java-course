package javase01.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by alexmich on 07.10.16.
 */
public class Notepad {
    private List<Record> records;

    public Notepad(){
        records = new ArrayList<>();
    }

    public Notepad(List<Record> records){
        this.records = records;
    }

    public boolean add(Record record){
        return records.add(record);
    }

    public Record remove(int index){
        return records.remove(index);
    }

    public boolean remove(Record record){
        return records.remove(record);
    }

    public void edit(int index, Record newRec) throws IndexOutOfBoundsException{
        records.remove(index);
        records.add(index,newRec);
    }

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
