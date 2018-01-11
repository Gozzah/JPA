/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
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
    
    public void createBook(Book book){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
    
    public Book getBook(int isbn){
        EntityManager em = getEntityManager();
        
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.ISBN = :ISBN");
        query.setParameter("ISBN", isbn);
        
        return (Book) query.getSingleResult();
    }
    
    public void updateBookTitle(String title, int isbn){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery("UPDATE Book b SET b.title = :title WHERE b.isbn = :ISBN");
        query.setParameter("title", title);
        query.setParameter("ISBN", isbn).executeUpdate();
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void createEBook(EBook ebook){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(ebook);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<EBook> getAllEBooks(int isbn){
        EntityManager em = getEntityManager();
        
      TypedQuery<EBook> query = em.createQuery(
        "SELECT c FROM Customer AS c", EBook.class);
        List<EBook> results = query.getResultList();
        return results;
    }
    
    public void createPaperBook(PaperBook paperBook){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(paperBook);
        em.getTransaction().commit();
        em.close();
    }
    
        public void deletePaperBook(int isbn){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM PaperBook p WHERE p.isbn = :isbn");
        query.setParameter("isbn", isbn).executeUpdate();
        
        em.getTransaction().commit();
        em.close();
    }
    
       public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}
