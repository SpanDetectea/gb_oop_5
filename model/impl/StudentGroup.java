package model.impl;

import java.util.List;

public class StudentGroup {
    int number;
    Teacher teacher;
    List<Student> students;
    public StudentGroup(Teacher teacher, List<Student> students, int number) {
        this.teacher = teacher;
        this.students = students;
        this.number = number;
    }
    public List<Student> getStudents() {
        return students;
    }
    public Teacher getTeacher() {
        return teacher;
    }
}
