/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author phamd
 */
import java.util.ArrayList;
import java.util.List;

//public class StudentManagementSystem {
//    private List<Student> students;
//
//   // Constructor để khởi tạo danh sách sinh viên
//    public StudentManagementSystem() {
//        students = new ArrayList<>();
//    }
//
//    // Phương thức để thêm một sinh viên vào danh sách
//    public void addStudent(Student student) {
//        students.add(student);
//    }
//
//    // Phương thức để chỉnh sửa chi tiết của một sinh viên hiện có
//    public void editStudent(int id, String name, double marks) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                student.setName(name);
//                student.setMarks(marks);
//                return;
//            }
//        }
//    }
//
//    // Phương thức để xóa một sinh viên khỏi danh sách dựa trên ID của họ
//    public void deleteStudent(int id) {
//        students.removeIf(student -> student.getId() == id);
//    }
//
//    // Phương thức để tìm kiếm một sinh viên theo ID của họ
//    public Student searchStudent(int id) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                return student;
//            }
//        }
//        return null;
//    }
//
//    // Phương thức để sắp xếp các sinh viên theo điểm số giảm dần bằng sắp xếp chọn (selection sort)
//    public void sortStudents() {
//        int n = students.size();
//        for (int i = 0; i < n-1; i++) {
//            // Tìm sinh viên có điểm số lớn nhất trong các phần tử còn lại
//            int maxIdx = i;
//            for (int j = i+1; j < n; j++) {
//                if (students.get(j).getMarks() > students.get(maxIdx).getMarks()) {
//                    maxIdx = j;
//                }
//            }
//            // Hoán đổi sinh viên có điểm số lớn nhất với sinh viên tại vị trí i
//            Student temp = students.get(maxIdx);
//            students.set(maxIdx, students.get(i));
//            students.set(i, temp);
//        }
//    }
//
//    // Phương thức để hiển thị danh sách sinh viên
//    public void displayStudents() {
//        for (Student student : students) {
//            System.out.println(student);
//        }
//    }
//}


public class StudentManagementSystem {
    private List<Student> students;

    // Constructor để khởi tạo danh sách sinh viên
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Phương thức để thêm một sinh viên vào danh sách
    public void addStudent(Student student) {
        students.add(student);
    }

    // Phương thức để chỉnh sửa chi tiết của một sinh viên hiện có
    public void editStudent(int id, String name, double marks) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setMarks(marks);
                return;
            }
        }
    }

    // Phương thức để xóa một sinh viên khỏi danh sách dựa trên ID của họ
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    // Phương thức để tìm kiếm một sinh viên theo ID của họ
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Phương thức để sắp xếp các sinh viên theo điểm số giảm dần bằng merge sort
    public void sortStudents() {
        if (students.size() <= 1) {
            return;
        }
        students = mergeSort(students);
    }

    private List<Student> mergeSort(List<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList;
        }

        int mid = studentList.size() / 2;
        List<Student> left = new ArrayList<>(studentList.subList(0, mid));
        List<Student> right = new ArrayList<>(studentList.subList(mid, studentList.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> sortedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMarks() > right.get(j).getMarks()) {
                sortedList.add(left.get(i));
                i++;
            } else {
                sortedList.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            sortedList.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            sortedList.add(right.get(j));
            j++;
        }

        return sortedList;
    }

    // Phương thức để hiển thị danh sách sinh viên
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
