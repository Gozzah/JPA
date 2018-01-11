/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.Orders;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;

/**
 *
 * @author Peter Riis
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU", null);
        EntityManager em = emf.createEntityManager();
        
        Facade facade = new Facade(emf);
        
        ItemType itemType = new ItemType();
        
        Customer customer = new Customer();
        Customer customer2 = new Customer();
        
        Orders order = new Orders();
        Orders order2 = new Orders();
        
        customer.setName("Hans");
        customer.setEmail("hansemand@hotmail.com");
        customer2.setName("Jørgen");
        customer2.setEmail("Jørgenboi@hotmail.com");
        
        itemType.setName("hammer");
        itemType.setDescription("den slår søremer hårdt");
        itemType.setPrice(85);
        
        OrderLine orderLine = new OrderLine();
        
        orderLine.setQuantity(4);
        
        em.getTransaction().begin();
        
        facade.createCustomer(customer);
        facade.createCustomer(customer2);
        facade.createOrder(order,customer);
        facade.createOrder(order2,customer2);
        facade.createItemType(itemType);
        facade.createOrderLine(orderLine,itemType,order);
        
        em.getTransaction().commit();
        em.close();
    }
}
