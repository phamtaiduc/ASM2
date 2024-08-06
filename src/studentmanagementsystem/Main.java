/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author phamd
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sm = new StudentManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students");
            System.out.println("6. Display Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    sm.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new Name: ");
                    name = scanner.next();
                    System.out.print("Enter new Marks: ");
                    marks = scanner.nextDouble();
                    sm.editStudent(id, name, marks);
                    break;
                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    id = scanner.nextInt();
                    sm.deleteStudent(id);
                    break;
                case 4:
                    System.out.print("Enter ID of student to search: ");
                    id = scanner.nextInt();
                    Student student = sm.searchStudent(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    sm.sortStudents();
                    System.out.println("Students sorted:");
                    sm.displayStudents();
                    break;
                case 6:
                    sm.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}

