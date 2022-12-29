package com.guluev.databasewithhibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Check(constraints = "age>7")
    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String phone_number;
}
