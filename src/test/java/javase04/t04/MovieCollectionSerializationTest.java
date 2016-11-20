package javase04.t04;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static javase04.t04.Person.Sex.*;
import static org.junit.Assert.assertTrue;
import static utils.Utils.getAbsoluteResourcePath;


public class MovieCollectionSerializationTest {
    static MovieCollection collection = new MovieCollection();

    @BeforeClass
    public static void makeCollection(){
        Actor actor1 = new Actor("CAA","Brad", "Pitt",52,MALE);
        Actor actor2 = new Actor("unknown","Benicio", "del Toro",49,MALE);
        Actor actor3 = new Actor("UTA","Edward","Norton",47,MALE);
        Movie movie1 = new Movie("Fear and loathing in Los Vegas",new Person("Terry", "Gilliam",76,MALE),1998);
        Movie movie2 = new Movie("Fight club",new Person("David", "Fincher",54,MALE),1999);
        collection.put(movie1, Arrays.asList(actor1,actor2));
        collection.put(movie2,Arrays.asList(actor1,actor3));
    }

    @Test
    public void serializationTest(){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getAbsoluteResourcePath("collection")))) {
            outputStream.writeObject(collection);
        }catch(IOException e) {
            e.printStackTrace();
        }
        MovieCollection deserializedCollection;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(getAbsoluteResourcePath("collection")))) {
            deserializedCollection = (MovieCollection) inputStream.readObject();
            assertTrue(deserializedCollection.equals(collection));
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
