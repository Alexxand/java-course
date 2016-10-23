package javase02.t05;

import org.junit.Test;

import java.io.PipedInputStream;
import java.io.PushbackReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javase02.t05.Group.Discipline.MATH;
import static javase02.t05.Group.Discipline.PHYSICS;
import static javase02.t05.Student.Sex.FEMALE;
import static javase02.t05.Student.Sex.MALE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexmich on 17.10.16.
 */
public class DisciplineRegistratorTest {
    private final Student typicalStudent1 = new Student("Ivan","Ivanych",20, MALE);
    private final Student typicalStudent2 = new Student("Victor","Vitaminych",45,MALE);
    private final Student typicalStudent3 = new Student("Ella","Vladimirovna",35,FEMALE);
    private final List<Student> listOfStudents1 = new ArrayList<>(Arrays.asList(typicalStudent1,typicalStudent2,typicalStudent3));
    private final List<Number> listOfMarks1 = new ArrayList<>(Arrays.asList(17.8,16.3,15.));
    private final Group typicalGroup1 = new Group(listOfStudents1,listOfMarks1, PHYSICS);
    private final List<Student> listOfStudents2 = new ArrayList<>(Arrays.asList(typicalStudent1,typicalStudent3));
    private final List<Number> listOfMarks2 = new ArrayList<>(Arrays.asList(15,18));
    private final Group typicalGroup2 = new Group(listOfStudents2,listOfMarks2, MATH);



    @Test
    public void addGroup(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup1);
        assertTrue(registrator.doesGroupExist(typicalGroup1));
    }

    @Test
    public void removeGroup(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup1);
        registrator.removeGroup(PHYSICS);
        assertTrue(!registrator.doesGroupExist(typicalGroup1));
    }

    @Test
    public void addStudent(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup2);
        registrator.addStudent(typicalStudent2,new ArrayList<>(Collections.singletonList(MATH)),new ArrayList<>(Collections.singletonList(17)));
        assertTrue(registrator.doesStudentExist(typicalStudent2));

    }

    @Test
    public void removeStudent(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup2);
        registrator.removeStudent(typicalStudent1);
        assertTrue(!registrator.doesStudentExist(typicalStudent1));
    }

    @Test
    public void changeMark(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup2);
        registrator.changeMark(typicalStudent1,MATH,5);
        assertEquals(new Double(5),registrator.getMark(typicalStudent1,MATH));
    }

    @Test
    public void getAverageMark(){
        DisciplineRegistrator registrator = new DisciplineRegistrator();
        registrator.addGroup(typicalGroup1);
        registrator.addGroup(typicalGroup2);
        assertEquals(new Double(16.4),registrator.getAverageMark(typicalStudent1));
    }

}
