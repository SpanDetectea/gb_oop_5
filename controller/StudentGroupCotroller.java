package controller;

import java.util.List;

import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;
import service.StudentGroupService;

public class StudentGroupCotroller {
    private StudentGroupService sg = new StudentGroupService();

     public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        return sg.createStudentGroup(teacher, students);
    }
    public List<Student> getStudents(int groupNumber) {
        return sg.getStudents(groupNumber);
    }
    public Teacher getTeacher(int groupNumber) {
        return sg.getTeacher(groupNumber);
    }
}
