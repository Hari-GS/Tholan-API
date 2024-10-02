package com.example.tholanapi.services;


import com.example.tholanapi.models.*;
import com.example.tholanapi.repo.BlockRepo;
import com.example.tholanapi.repo.CropsRepo;
import com.example.tholanapi.repo.SoilRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    BlockRepo blockRepo;

    @Autowired
    CropsRepo cropsRepo;

    @Autowired
    Response response;

    @Autowired
    SoilRepo soilRepo;

    @Autowired
    GetCrops getCrops;

    public OorBlock fetchBlockDetails(String block){
        OorBlock oorBlock= blockRepo.findByBlockName(block);
        return oorBlock;
    }

    public List<String> fetchAllBlocks(){
        return blockRepo.findAllBlockNames();
    }

    public Response fetchResults(String blockName) throws Exception {
        response.setBlockName(blockName);

        //setting soil details
        String soilTypeJson = soilRepo.findByName(blockName);
        String soilType = extractSoilType(soilTypeJson);
        response.setSoilType(soilType);

        response.setWeather(WeatherAPI.fetchWeatherDataForThanjavur());

        LocalDate currentDate = LocalDate.now();
        response.setDate(currentDate.toString());


        response.setIrrigated(inserterIr(getCrops.getIrrigatedCrops(blockName)));

        response.setRainfed(inserterRa(getCrops.getRainfedCrops(blockName)));

        return response;
    }

    private String extractSoilType(String soilTypeJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse the JSON string
            JsonNode jsonNode = objectMapper.readTree(soilTypeJson);
            // Extract the "soilType" value
            return jsonNode.get("soilType").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle the error appropriately
        }
    }

    private List<Crops> inserterIr(List<String> list){
        List<Crops> cropsList = cropsRepo.findByCropNameIn(list);
        return cropsList;
    }

    private List<Crops> inserterRa(List<String> list){
        List<Crops> cropsList = cropsRepo.findByCropNameIn(list);
        return cropsList;
    }
}
