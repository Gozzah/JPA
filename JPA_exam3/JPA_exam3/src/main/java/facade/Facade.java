/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Peter Riis
 */
public class Facade {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU",null);

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public List<Student> findAllStudents(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Student> query =
        em.createNamedQuery("Student.findAll",Student.class);
        List<Student> result = query.getResultList();
        return result;
    }
    
    public List findAllAnders(String firstName){
        EntityManager em = getEntityManager();
        
        TypedQuery<Student> query =
        em.createNamedQuery("Student.findByFirstname",Student.class);
        List<Student> result = query.getResultList();
        return result;
    }
    
    public void createStudent(String firstName, String lastName){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query =
        em.createNativeQuery("INSERT INTO Student (firstName,lastName)" +
        "VALUES(?,?)");
        query.setParameter(1, firstName);
        query.setParameter(2, lastName);
        query.executeUpdate();
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void assignStudent(String firstName){
        EntityManager em = getEntityManager();
        
        Query query = 
        em.createQuery("SELECT s FROM Student s WHERE s.firstname = :firstname");
        query.setParameter("firstname", firstName);
        Student student = (Student) query.getSingleResult();
        
        
        
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
