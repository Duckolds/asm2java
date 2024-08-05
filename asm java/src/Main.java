import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter student information");
            System.out.println("2. Print student list");
            System.out.println("3. Delete student by code");
            System.out.println("4. Sort students by descending grade");
            System.out.println("5. Search students by code or name");
            System.out.println("6. Search students with grade >= x");
            System.out.println("7. Exit");
            System.out.print("Select a function: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer.");
                scanner.nextLine(); // clear buffer
                continue;
            }
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.print("Enter the student code to delete: ");
                    String code = scanner.nextLine();
                    removeByCode(code);
                    break;
                case 4:
                    sortByGradeDesc();
                    break;
                case 5:
                    System.out.print("Enter the student code or name to search: ");
                    String keyword = scanner.nextLine();
                    Student student = findByCodeOrName(keyword);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter grade x: ");
                    float x = 0;
                    try {
                        x = scanner.nextFloat();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter a decimal number.");
                        scanner.nextLine(); // clear buffer
                        continue;
                    }
                    List<Student> filteredStudents = filterByGrade(x);
                    for (Student s : filteredStudents) {
                        System.out.println(s);
                    }
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid function selection. Please try again.");
            }
        }
    }

    // Input new student information
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter student information:");
            System.out.print("Enter student code: ");
            String code = scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            if (name.matches(".*\\d.*")) {
                throw new InputMismatchException("Name cannot contain numbers.");
            }
            System.out.print("Enter age: ");
            int age = 0;
            try {
                age = scanner.nextInt();
                if (age < 0) {
                    throw new InputMismatchException("Age cannot be negative.");
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Age must be an integer.");
            }
            scanner.nextLine(); // consume newline
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            if (!email.contains("@")) {
                throw new InputMismatchException("Email must contain '@'.");
            }
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();
            if (!phone.matches("\\d{10}")) {
                throw new InputMismatchException("Phone number must have 10 digits.");
            }
            System.out.print("Enter gender (0 - Female, 1 - Male): ");
            int gender = scanner.nextInt();
            if (gender != 0 && gender != 1) {
                throw new InputMismatchException("Gender can only be 0 (Female) or 1 (Male).");
            }
            System.out.print("Enter grade: ");
            float grade = scanner.nextFloat();
            if (grade < 0 || grade > 10) {
                throw new InputMismatchException("Grade must be between 0 and 10.");
            }
            scanner.nextLine(); // consume newline

            Student student = new Student(name, age, email, phone, code, gender, grade);
            studentList.add(student);
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage() + " Please try again.");
            scanner.nextLine(); // clear buffer
        }
    }

    // Print the list of students
    public static void output() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Delete a student by code
    public static void removeByCode(String code) {
        boolean removed = studentList.removeIf(student -> student.getCode().equals(code));
        if (!removed) {
            System.out.println("No student found with code: " + code);
        } else {
            System.out.println("Removed student with code: " + code);
        }
    }

    // Sort students by descending grade
    public static void sortByGradeDesc() {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade).reversed());
        System.out.println("Student list after sorting:");
        output();
    }

    // Search for a student by student code or student name
    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    // Search for students with grade >= x
    public static List<Student> filterByGrade(float x) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
