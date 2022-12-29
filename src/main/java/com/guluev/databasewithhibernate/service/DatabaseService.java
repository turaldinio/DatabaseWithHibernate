package com.guluev.databasewithhibernate.service;

import com.guluev.databasewithhibernate.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private final DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public String getProductName(String name) {
        return databaseRepository.getProductName(name);
    }
}
