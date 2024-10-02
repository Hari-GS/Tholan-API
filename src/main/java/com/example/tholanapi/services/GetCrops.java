package com.example.tholanapi.services;

import com.example.tholanapi.models.OorBlock;
import com.example.tholanapi.repo.BlockRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetCrops {

    @Autowired
    BlockRepo blockRepo;

    public List<String> getIrrigatedCrops(String blockName){
        List<String> irCrops= blockRepo.findIrrigatedCropsByBlockName(blockName);
        System.out.println(irCrops.toString());
        return extractCropNames(irCrops.toString(),"irrigatedCrops");
    }

    public List<String> getRainfedCrops(String blockName) {
        List<String> rainCr = blockRepo.findRainfedCropsByBlockName(blockName);
        return extractCropNames(rainCr.toString(),"rainfedCrops");

    }

    public List<String> extractCropNames(String json, String feild) {
        List<String> cropNames = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode irrigatedCropsNode = rootNode.get(0).get(feild);
            if (irrigatedCropsNode != null && irrigatedCropsNode.isArray()) {
                for (JsonNode cropNode : irrigatedCropsNode) {
                    cropNames.add(cropNode.asText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cropNames;
    }

}

