/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aomms
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //Student std1 = new Student("1", "Max", 4.00);
       //Student std2 = new Student("2", "Molly", 3.55);
       //Student std3 = new Student("3", "Jayne",  2.27);
       //StudentTable.insertStudent(std1);
       //StudentTable.insertStudent(std2);
       //StudentTable.insertStudent(std3);
       //Student std;
       //std = StudentTable.findStudentById(1);
       //if (std != null) {
       //    std.setName("Jack");
           //StudentTable.removeStudent(std);
       //    StudentTable.updateStudent(std);
       //}
       //List<Student> stdList = StudentTable.findStudentByName("Marry"); 
       List<Student> stdList = StudentTable.findAllStudent();
       printAllStudent(stdList);
    }
public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
       }
    }
public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
