package javase02.t05;

import org.junit.Test;

import static javase02.t05.Student.Sex.FEMALE;
import static javase02.t05.Student.Sex.MALE;
import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void createStudent(){
        Student student = new Student("Ivan","Ivanych",20, MALE);
        assertEquals("Ivan",student.getName());
        assertEquals("Ivanych",student.getSurname());
        assertEquals(20,(int)student.getAge());
        assertEquals(MALE,student.getSex());
    }

    @Test
    public void setName(){
        Student student = new Student("Ivan","Ivanych",20, MALE);
        student.setName("Vitya");
        assertEquals("Vitya",student.getName());
    }

    @Test
    public void setSurname(){
        Student student = new Student("Ivan","Ivanych",20, MALE);
        student.setSurname("Vitaminych");
        assertEquals("Vitaminych",student.getSurname());
    }

    @Test
    public void setAge(){
        Student student = new Student("Ivan","Ivanych",20, MALE);
        student.setAge(50);
        assertEquals(50,(int)student.getAge());
    }

    @Test
    public void setSex(){
        Student student = new Student("Ivan","Ivanych",20, MALE);
        student.setSex(FEMALE);
        assertEquals(FEMALE,student.getSex());
    }



}