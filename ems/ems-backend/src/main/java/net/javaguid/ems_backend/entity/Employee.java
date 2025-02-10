package net.javaguid.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// As we added lombok dependency
//@Getter,@Setter,@NoArgsConstructor,@AllArgsConstructor are used annotations form to auto generate getter,setter and constructors
//it reduces boilerplate code

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees1")
public class Employee
{
    @Id//primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)// use to auto generate next value
    private int id;
    @Column(name = "name")
    private String Name;
    @Column(name = "department")
    private int department;
    @Column(name = "email_id",nullable = false, unique = true)
    private String email;
    @Column(name = "position")
    private String position;

}
