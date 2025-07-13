package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (findStudentById(student.getStudentId()) != null) {
            throw new IllegalArgumentException("Student ID already exists.");
        }
        students.add(student);
    }

    public boolean deleteStudent(int studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    private Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}

