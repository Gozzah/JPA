package entity;

import entity.Customer;
import entity.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-09T18:12:04")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile ListAttribute<Orders, OrderLine> orderLines;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Customer> customer;

}