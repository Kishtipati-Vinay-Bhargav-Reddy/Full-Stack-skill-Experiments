package com.examplee;



import com.example.dao.StudentDAO;
import com.example.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // CREATE
        Student s1 = new Student("RAMA", "Hyderabad");
        dao.saveStudent(s1);

        int id = s1.getId();
        System.out.println("Generated ID = " + id);

        // READ
        Student s2 = dao.getStudent(id);
        if (s2 != null) {
            System.out.println("Student Name = " + s2.getName());
        }

        // UPDATE
        s2.setCity("Vijayawada");
        dao.updateStudent(s2);
        System.out.println("City Updated");

        // DELETE
        dao.deleteStudent(id);
        System.out.println("Student Deleted");

        System.out.println("CRUD COMPLETED SUCCESSFULLY");
    }
}

