package com.guluev.databasewithhibernate.controller;

import com.guluev.databasewithhibernate.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class DatabaseController {
    private final DatabaseService dataBaseService;

    public DatabaseController(DatabaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }


    @GetMapping("fetch-product")
    public String doSomething(String name) {
        return dataBaseService.getProductName(name);
    }
}

