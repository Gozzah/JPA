/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter Riis
 */
public class Tester2 {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU",null);
        Facade facade = new Facade(emf);
        //System.out.println(facade.getCustomer(1).getName());
        //System.out.println(facade.getCustomers().size());
        
        
        facade.getTotalPrice(1);
    }
}
