package com.example.nutritioncalculator.person_info.dto;

import com.example.nutritioncalculator.person_info.PersonEntity;
import lombok.Data;

@Data
public class PersonDTO {
    private String name;
    private Integer age;
    private Double weight;
    private Double height;
    private Integer bmr;
    private Integer amr;
    private Integer requiredCalories;

    public static PersonDTO fromEntity(PersonEntity entity) {
        PersonDTO dto = new PersonDTO();
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setHeight(entity.getHeight());
        dto.setWeight(entity.getWeight());
        dto.setBmr(entity.getBmr());
        dto.setAmr(entity.getAmr());
        dto.setRequiredCalories(entity.getRequiredCalories());
        return dto;
    }
}
