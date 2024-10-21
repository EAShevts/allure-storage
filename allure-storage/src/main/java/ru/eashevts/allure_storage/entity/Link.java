package ru.eashevts.allure_storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "links")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String name;
    private String url;

    // Getters and Setters
}