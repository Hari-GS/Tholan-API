package com.example.tholanapi.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@EntityScan
@Document(collection = "crop-details")
@Data
public class OorBlock {
    @Id
    private ObjectId id;
    private String blockName;
    private ArrayList irrigatedCrops;
    private ArrayList rainfedCrops;
}
