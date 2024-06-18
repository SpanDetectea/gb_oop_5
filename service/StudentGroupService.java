package service;

import java.util.List;

import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;

public class StudentGroupService {
    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        int number = DataBase.studentsGroupDB.size()+1;
        StudentGroup group = new StudentGroup(teacher, students, number);
        DataBase.studentsGroupDB.add(group);
        return group;
    }
    public List<Student> getStudents(int groupNumber) {
        return DataBase.studentsGroupDB.get(groupNumber).getStudents();
    }
    public Teacher getTeacher(int groupNumber) {
        return DataBase.studentsGroupDB.get(groupNumber).getTeacher();
    }
}
