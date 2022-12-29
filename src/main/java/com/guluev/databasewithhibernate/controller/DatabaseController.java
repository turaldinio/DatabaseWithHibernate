package com.guluev.databasewithhibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class DatabaseController {
    @RestController
    @RequestMapping("/products")
    public class DataBaseController {
        private final DatabaseService dataBaseService;

        public DataBaseController(DatabaseService databaseService) {
            this.dataBaseService = dataBaseService;
        }

        @GetMapping("fetch-product")
        public String doSomething(String name) {
            return dataBaseService.getProductName(name);
        }
    }
}
