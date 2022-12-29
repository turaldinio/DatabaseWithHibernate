package com.guluev.databasewithhibernate.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date date;

    @ManyToOne(optional = false)
    private Customers customer;

    private String productName;

    private double amount;
}
