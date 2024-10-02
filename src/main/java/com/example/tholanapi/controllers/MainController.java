package com.example.tholanapi.controllers;

import com.example.tholanapi.models.OorBlock;
import com.example.tholanapi.models.Response;
import com.example.tholanapi.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MainController {

    @Autowired
    Service service;

    @GetMapping("/test")
    public void test(){
        System.out.println("test success");
    }

    @GetMapping("getCropsDets/{blockName}")
    public OorBlock getCropsDetails(@PathVariable String blockName){
        blockName = blockName.substring(0, 1).toUpperCase() + blockName.substring(1);
        return service.fetchBlockDetails(blockName);
    }

    @GetMapping("/getBlocks")
    public List<String> getBlocks() {
        System.out.println("called");
        List<String> list= service.fetchAllBlocks();
        System.out.println(list.toString());
        return list;
    }

    @GetMapping("/getRes/{blockName}")
    public Response getResult(@PathVariable String blockName) throws Exception {
        blockName = blockName.substring(0, 1).toUpperCase() + blockName.substring(1);
        return service.fetchResults(blockName);
    }
}
