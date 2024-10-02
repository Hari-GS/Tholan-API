package com.example.tholanapi.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Response {
    private String blockName;
    private String soilType;
    private String weather;
    private String date;
    private List<Crops> irrigated;
    private List<Crops> rainfed;

}
