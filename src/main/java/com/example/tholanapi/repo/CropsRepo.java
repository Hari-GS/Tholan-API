package com.example.tholanapi.repo;

import com.example.tholanapi.models.Crops;
import com.example.tholanapi.models.OorBlock;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CropsRepo extends MongoRepository<Crops, ObjectId> {
    Crops findByCropName(String blockName);

    List<Crops> findByCropNameIn(List<String> cropNames);
}
