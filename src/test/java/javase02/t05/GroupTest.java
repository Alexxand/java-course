package javase02.t05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static javase02.t05.Group.Discipline.MATH;
import static javase02.t05.Group.Discipline.PHYSICS;
import static javase02.t05.Student.Sex.MALE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GroupTest {
    private final Student typicalStudent = new Student("Ivan","Ivanych",20, MALE);

    @Test
    public void createEmptyGroup(){
        Group group = new Group(new ArrayList<>(),new ArrayList<>(), PHYSICS);
        assertTrue(group.isEmpty());
        assertEquals(PHYSICS,group.getDiscipline());
    }

    @Test
    public void addStudent(){
        Group group = new Group(new ArrayList<>(),new ArrayList<>(), PHYSICS);
        group.addStudent(typicalStudent,10);
        assertTrue(group.doesStudentExist(typicalStudent));
        assertEquals(new Double(10),group.getMark(typicalStudent));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithInappropriateMarkType(){
        Group group = new Group(new ArrayList<>(),new ArrayList<>(), MATH);
        group.addStudent(typicalStudent,10.0);
    }

    @Test
    public void changeMark(){
        Group group = new Group(new ArrayList<>(),new ArrayList<>(), PHYSICS);
        group.addStudent(typicalStudent,10);
        group.changeMark(typicalStudent,10.2);
        assertEquals(new Double(10.2),group.getMark(typicalStudent));
    }

    @Test
    public void removeStudent(){
        Group group = new Group(new ArrayList<>(),new ArrayList<>(), PHYSICS);
        group.addStudent(typicalStudent,10);
        group.removeStudent(typicalStudent);
        assertTrue(!group.doesStudentExist(typicalStudent));
    }

}
