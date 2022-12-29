package com.guluev.databasewithhibernate.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int customer_id;

    private String productName;

    private double amount;
}
