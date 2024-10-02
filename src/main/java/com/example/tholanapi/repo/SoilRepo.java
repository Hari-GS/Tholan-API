package com.example.tholanapi.repo;

import com.example.tholanapi.models.OorBlock;
import com.example.tholanapi.models.Soil;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoilRepo extends MongoRepository<Soil, ObjectId> {
    String findByName(String name);
}
