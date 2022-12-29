package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class DatabaseRepository {
    private String select;

    @PersistenceContext
    private EntityManager entityManager;

    public DatabaseRepository() {
        select = read("sqlcomands/select.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        //var result = entityManager.createQuery(select, Orders.class);
        var result = entityManager.createQuery(select, Orders.class);
        result.setParameter("name", name);
        return result.getResultList().get(0).getProductName();
    }
}