package javase02.t05;

import java.util.List;

import static javase02.t05.Group.Discipline.*;

/**
 * Created by alexmich on 14.10.16.
 */
public class Group {

    public Group(List<Student> listOfStudents, List<Number> listOfMarks, Discipline discipline/*, MarkType markType*/){

    }

    public boolean addStudent(Student student,Number mark){
        return true;
    }

    public boolean changeMark(Student student, Number mark){
        return true;
    }

    public Double getMark(Student student){
        return 0.;
    }

    public boolean removeStudent(Student student){
        return true;
    }

    public Double getMarkForStudent(Student student){
        return 0.;
    }

    public Discipline getDiscipline(){
        return PHYSICS;
    }

    public boolean isCurDiscipline(Discipline discipline){
        return true;
    }

    public enum Discipline{
        PHYSICS(MarkType.INTEGER);

        private MarkType markType;

        Discipline(MarkType markType){
            this.markType = markType;
        }
    }
    public enum MarkType{
        INTEGER,
        REAL;
    }
}
