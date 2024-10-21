package ru.eashevts.allure_storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "labels")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "label_value", nullable = false, columnDefinition = "TEXT")
    private String value;

    // Getters and Setters
}