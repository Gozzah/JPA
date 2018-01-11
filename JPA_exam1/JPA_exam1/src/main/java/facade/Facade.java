/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.Orders;
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
    
    public void createCustomer(Customer cust){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        em.close();
    }
    
    public Customer getCustomer(int id){
        EntityManager em = getEntityManager();
        
        Query query = 
        em.createQuery("SELECT c FROM Customer c WHERE c.id = :ID");
        query.setParameter("ID", id);
        return (Customer) query.getSingleResult();
    }
    
    public List<Customer> getCustomers(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Customer> query = em.createQuery(
        "SELECT c FROM Customer AS c", Customer.class);
        List<Customer> results = query.getResultList();
        return results;
    }
    
    public void createOrder(Orders order, Customer customer){
        EntityManager em = getEntityManager();
        
        order.setCustomer(customer);
        
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }
    
    public void addOrderToCust(Orders order){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        
    }
    
    public Orders findOrder(int id){
        EntityManager em = getEntityManager();
        
        Query query = 
        em.createQuery("SELECT o FROM Orders o WHERE o.id = :ID");
        query.setParameter("ID", id);
        return (Orders) query.getSingleResult();
    }
    
    public void createItemType(ItemType itemType){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(itemType);
        em.getTransaction().commit();
        em.close();
    }
    public void createOrderLine(OrderLine orderLine, ItemType itemType, Orders order){
        EntityManager em = getEntityManager();
        
        orderLine.setItemType(itemType);
        orderLine.setOrders(order);
        
        em.getTransaction().begin();
        em.persist(orderLine);
        em.getTransaction().commit();
        em.close();
    }
    
        public OrderLine findOrderLine(int id){
        EntityManager em = getEntityManager();
        
        Query query = 
        em.createQuery("SELECT o FROM OrderLine o WHERE o.id = :ID");
        query.setParameter("ID", id);
        return (OrderLine) query.getSingleResult();
    }
        
        
        public ItemType findItemType(int id){
        EntityManager em = getEntityManager();
        
        Query query = 
        em.createQuery("SELECT i FROM ItemType i WHERE i.id = :ID");
        query.setParameter("ID", id);
        return (ItemType) query.getSingleResult();
    }    
    
    
    public double getTotalPrice(int id){
        
        int quantity = findOrderLine(id).getQuantity();
        double price = findItemType(id).getPrice();
        
        double totalPrice = price * quantity;
        
        return totalPrice;
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
