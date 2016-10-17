package javase02.t05;

import java.util.List;

import javase02.t05.Group.Discipline;

/**
 * Created by alexmich on 14.10.16.
 */
public class DisciplineRegistrator {

public boolean addStudent(Student student, List<Discipline> listOfDisciplines, List<Number> listOfMarks){
    return true;
}

public boolean addGroup(List<Student> listOfStudents, List<Number> listOfMarks, Discipline discipline/*, MarkType markType*/){
    return true;
}

public boolean changeMark(Student student, Discipline discipline, Number mark){
    return true;
}

public Double getMark(Student student, Discipline discipline){
    return 0.;
}

public boolean removeStudent(Student student){
    return true;
}

public boolean removeDiscipline(Discipline name){
    return true;
}

public List<Group> getGroupsForStudent(Student student){
    return null;
}

public Group getGroup(Discipline discipline){
    return null;
}
}
