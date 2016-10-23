package javase02.t05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javase02.t05.Group.Discipline;

/**
 * Created by alexmich on 14.10.16.
 */
public class DisciplineRegistrator {

private List<Group> listOfGroups = new ArrayList<>();


public void addStudent(Student student, List<Discipline> listOfDisciplines, List<Number> listOfMarks){
    for (Discipline discipline: listOfDisciplines){
        Number mark = listOfMarks.get(listOfDisciplines.indexOf(discipline));
        boolean doesDisciplineExist = false;
        for (Group group: listOfGroups){
            if (group.getDiscipline() == discipline){
                group.addStudent(student,mark);
                doesDisciplineExist = true;
                break;
            }
            //Arrays.asList();
        }
        if (!doesDisciplineExist){
            listOfGroups.add(new Group(new ArrayList<>(Collections.singletonList(student)),new ArrayList<>(Collections.singletonList(mark)),discipline));
            //listOfGroups.add(new Group(Arrays.asList(student),Arrays.asList(mark),discipline));
        }
    }
}

public boolean addGroup(Group group){
    return listOfGroups.add(group);
}

public boolean doesGroupExist(Group group){
    return listOfGroups.contains(group);
}

public boolean changeMark(Student student, Discipline discipline, Number mark){
    for (Group group: listOfGroups){
        if (group.getDiscipline() == discipline){
            group.changeMark(student,mark);
            return true;
        }

    }
    return false;
}

public Double getMark(Student student, Discipline discipline){
    for (Group group: listOfGroups){
        if(group.getDiscipline() == discipline)
            return group.getMark(student);
    }
    return 0.;
}

public boolean doesStudentExist(Student student){
    for(Group group: listOfGroups){
        if (group.doesStudentExist(student))
            return true;
    }
    return false;
}

public boolean removeStudent(Student student){
    for (Group group: listOfGroups){
        if (group.doesStudentExist(student)){
            group.removeStudent(student);
            return true;
        }
    }
    return false;
}

public boolean removeGroup(Discipline name){
    for (Group group: listOfGroups){
        if(group.getDiscipline() == name)
           return listOfGroups.remove(group);
    }
    return false;
}

private List<Group> getGroupsForStudent(Student student) {
    List<Group> listOfStudentGroups = new ArrayList<>();
    for (Group group : listOfGroups) {
        if (group.doesStudentExist(student)) {
            listOfStudentGroups.add(group);
        }
    }
    return listOfStudentGroups;
}

Double getAverageMark(Student student) {
    List<Group> listOfStudentGroups = getGroupsForStudent(student);
    double markSum = 0;
    for (Group group: listOfStudentGroups){
        markSum += group.getMark(student);
    }
    return markSum/listOfStudentGroups.size();
}
}
