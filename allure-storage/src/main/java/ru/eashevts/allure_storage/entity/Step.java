package ru.eashevts.allure_storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "steps")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private Long start;
    private Long stop;

    // Getters and Setters
}
