package com.example.tholanapi.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CropsDes {
    private String name;
    private String description;
    private String link;
}
