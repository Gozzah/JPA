package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T21:01:46")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Semester> currentsemesterId;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, String> lastname;

}