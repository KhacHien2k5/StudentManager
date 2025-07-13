import model.Student;
import service.StudentManager;
import util.InputHelper;
import java.util.List;

public class Main {
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = InputHelper.readInt("Choose: ");
            switch (choice) {
                case 1:
                    addStudentUI();
                    break;
                case 2:
                    deleteStudentUI();
                    break;
                case 3:
                    searchStudentUI();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n==== Student Management ====");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search by name");
        System.out.println("4. Display all students");
        System.out.println("0. Exit");
    }

    private static void addStudentUI() {
        try {
            int id = InputHelper.readInt("Enter ID: ");
            String name = InputHelper.readLine("Enter full name: ");
            double gpa = InputHelper.readDouble("Enter GPA: ");
            Student student = new Student(id, name, gpa);
            manager.addStudent(student);
            System.out.println("Added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudentUI() {
        int id = InputHelper.readInt("Enter ID to delete: ");
        boolean deleted = manager.deleteStudent(id);
        if (deleted) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudentUI() {
        String keyword = InputHelper.readLine("Enter name to search: ");
        List<Student> found = manager.searchByName(keyword);
        if (found.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println(String.format("%-10s %-30s %-4s", "ID", "Full Name", "GPA"));
            for (Student student : found) {
                System.out.println(student);
            }
        }
    }

    private static void displayAllStudents() {
        List<Student> students = manager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students.");
        } else {
            System.out.println(String.format("%-10s %-30s %-4s", "ID", "Full Name", "GPA"));
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
