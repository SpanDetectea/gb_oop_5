package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import controller.StudentGroupCotroller;
import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;

public class StudentGroupView {
    private StudentGroupCotroller controller = new StudentGroupCotroller();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать учебную группу");
            System.out.println("2 - показать студентов группы");
            System.out.println("3 - показать преподавателя группы");
            System.out.println("4 - выход");

            switch (scanner.nextInt()) {
                case 1 -> createStudentGroup();
                case 2 -> getStudents();
                case 3 -> getTeacher();
                case 4 -> System.exit(0);// выход из приложения

                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

    private StudentGroup createStudentGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите id преподавателя из списка: ");
        System.out.println(DataBase.teachersDB);
        int teacherId = scanner.nextInt()-1;
        Teacher teacher = DataBase.teachersDB.get(teacherId);
        System.out.println("Какое количество студентов вы хотите добавить?");
        int studentCount = scanner.nextInt();
        System.out.println(DataBase.studentsDB);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Введите id студента");
            int studentId = scanner.nextInt()-1;
            students.add(DataBase.studentsDB.get(studentId));
        }

        StudentGroup group = controller.createStudentGroup(teacher, students);
        return group;
    }

    private List<Student> getStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер учебной группы: ");
        int groupNumber = scanner.nextInt()-1;
        List<Student> students = controller.getStudents(groupNumber);
        System.out.println(students);
        return students;
    }

    private Teacher getTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер учебной группы: ");
        int groupNumber = scanner.nextInt()-1;
        Teacher teacher = controller.getTeacher(groupNumber);
        System.out.println(teacher);
        return teacher;
    }
}
