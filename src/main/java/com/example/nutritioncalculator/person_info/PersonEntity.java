package com.example.nutritioncalculator.person_info;

import com.example.nutritioncalculator.person_info.dto.PersonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Double weight;

    private Double height;

    private Integer bmr;

    private Integer amr;

    private Integer requiredCalories;

    public static PersonEntity getInstance(PersonDTO dto) {
        PersonEntity newPerson = new PersonEntity();
        newPerson.name = dto.getName();
        newPerson.age = dto.getAge();
        newPerson.weight = dto.getWeight();
        newPerson.height = dto.getHeight();
        newPerson.bmr = (int) Math.round(10 * dto.getWeight() + 6.25 * dto.getHeight() - 5 * dto.getAge());
        newPerson.amr = (int) Math.round(newPerson.bmr * 0.555);
        newPerson.requiredCalories = newPerson.bmr + newPerson.amr;
        return newPerson;
    }

    public void update(PersonDTO dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.weight = dto.getWeight();
        this.height = dto.getHeight();
    }
}
