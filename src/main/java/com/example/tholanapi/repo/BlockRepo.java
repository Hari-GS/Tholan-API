package com.example.tholanapi.repo;

import com.example.tholanapi.models.OorBlock;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BlockRepo extends MongoRepository<OorBlock, ObjectId> {
    OorBlock findByBlockName(String blockName);

    // Custom query method to fetch only block names
    @Query(value = "{}", fields = "{ 'blockName' : 1 }")
    List<String> findAllBlockNames();

    @Query(value = "{ 'blockName' : ?0, 'irrigatedCrops' : { $exists: true } }", fields = "{ 'irrigatedCrops' : 1, '_id' : 0 }")
    List<String> findIrrigatedCropsByBlockName(String blockName);

    @Query(value = "{ 'blockName' : ?0, 'rainfedCrops' : { $exists: true } }", fields = "{ 'rainfedCrops' : 1, '_id' : 0 }")
    List<String> findRainfedCropsByBlockName(String blockName);
}
