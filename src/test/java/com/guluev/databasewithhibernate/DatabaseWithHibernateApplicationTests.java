package com.guluev.databasewithhibernate;

import com.guluev.databasewithhibernate.model.Customers;
import com.guluev.databasewithhibernate.model.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.*;

@SpringBootTest
class DatabaseWithHibernateApplicationTests {

    @PersistenceContext
    private EntityManager entityManager;


    @LocalServerPort
    private int port;

    private List<String> names = List.of("Dmitry", "Andrey", "Kirill", "Vladimir", "Sergey", "Fedor");
    private List<String> surnames = List.of("Orilov", "Serebrov", "Lavrov", "Kulikoov", "Sergeyeev", "Fedorov");
    private List<String> productsList = List.of("Iphone 13 pro max", "Imac Apple", "MacBook air 13", "Samsung Smart TV");


    @Transactional
    public void init() {
        var customers = names.stream().map(x -> Customers.
                builder().
                age(new Random().nextInt(80)).
                name(x).
                surname(surnames.get(new Random().nextInt(surnames.size()))).
                phoneNumber("23424").
                build()).toList();

        customers.forEach(entityManager::persist);

        var orders = customers.stream().map(s -> Orders.
                builder().
                date(new Date()).
                productName(productsList.get(new Random().nextInt(productsList.size()))).
                amount(new Random().nextDouble(1000)).
                customer(s).
                build()).toList();

        orders.forEach(entityManager::persist);

    }

    @Test
    @Transactional
    public void getDate() {
        init();

        var result = entityManager.createQuery("select o from Orders o join Customers c on o.customer.id=c.id where c.name= :name");
        result.setParameter("name", names.get(new Random().nextInt(names.size())));
        Assertions.assertNotNull(result.getResultList().get(0));

    }




}
