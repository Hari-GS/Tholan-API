package com.example.tholanapi.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection = "crops-more-details")
@Data
public class Crops {
    @Id
    private ObjectId id;
    private String cropName;
    private String description;
    private String moreDetails;

}
