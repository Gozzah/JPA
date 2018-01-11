/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter Riis
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU", null);
        EntityManager em = emf.createEntityManager();
        
        Book book = new Book();
        EBook ebook = new EBook();
        PaperBook paperBook = new PaperBook();
        
        book.setAuthor("Peter Riis");
        book.setTitle("Mit liv som studerende: en successhistorie");
        book.setPrice(85);
        
        ebook.setAuthor("Kirsten Hyttemeier");
        ebook.setTitle("Min fortid som spion");
        ebook.setDownloadURL("www.Vordingborgbibliotekerne.dk/hyttemeierErNice/GammelPETSpion");
        ebook.setSizeMB(850);
        ebook.setPrice(85);
        
        paperBook.setAuthor("Peter Gade");
        paperBook.setTitle("Hvordan man slår til en fjerbold");
        paperBook.setInStock(85);
        paperBook.setShippingWeight(850000);
        paperBook.setPrice(85);
        
        em.getTransaction().begin();
        em.persist(book);
        em.persist(ebook);
        em.persist(paperBook);
        em.getTransaction().commit();
        em.close();
        
    }
}
