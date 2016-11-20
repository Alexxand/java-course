package javase02.t05;

import java.util.List;

import static javase02.t05.Group.Discipline.*;


public class Group {

    private final List<Student> listOfStudents;
    private final List<Number> listOfMarks;
    private final Discipline discipline;


    public Group(List<Student> listOfStudents, List<Number> listOfMarks, Discipline discipline){
        this.listOfStudents = listOfStudents;
        this.listOfMarks = listOfMarks;
        this.discipline = discipline;
    }

    public boolean isEmpty(){
        return listOfStudents.isEmpty();
    }

    public boolean addStudent(Student student,Number mark) throws IllegalArgumentException{
        if (mark instanceof Double && discipline.getMarkType()==MarkType.INTEGER){
            throw new IllegalArgumentException();
        }
        return listOfStudents.add(student) && (listOfMarks.add(mark) || !listOfStudents.remove(student));
    }

    public void changeMark(Student student, Number mark){
        listOfMarks.set(listOfStudents.indexOf(student),mark);
    }

    public Double getMark(Student student){
        Number mark = listOfMarks.get(listOfStudents.indexOf(student));
        if (mark instanceof Integer)
            return (double)(int)listOfMarks.get(listOfStudents.indexOf(student));
        else
            return (Double) listOfMarks.get(listOfStudents.indexOf(student));
    }

    public boolean doesStudentExist(Student student){
        return listOfStudents.contains(student);
    }

    public void removeStudent(Student student){
        listOfMarks.remove(listOfMarks.get(listOfStudents.indexOf(student)));
        listOfStudents.remove(student);
    }

    public Discipline getDiscipline(){
        return discipline;
    }

    public enum Discipline{
        PHYSICS(MarkType.REAL),
        MATH(MarkType.INTEGER);

        private MarkType markType;

        Discipline(MarkType markType){
            this.markType = markType;
        }

        public MarkType getMarkType() {
            return markType;
        }
    }
    private enum MarkType{
        INTEGER,
        REAL;
    }
}
