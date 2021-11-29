package com.DBProject.auctionSystem.controller;

import com.DBProject.auctionSystem.model.dao.DataDao;
import com.DBProject.auctionSystem.model.dvo.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysController {

    private DataDao data1 = new DataDao();

    @GetMapping("/{query}")
    public String getQueryResult(@PathVariable String query){
        return data1.getQuery(query);
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello, " + name;
    }
}
