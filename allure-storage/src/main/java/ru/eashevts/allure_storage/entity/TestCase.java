package ru.eashevts.allure_storage.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "test_cases")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCase  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String testCaseId;
    @Column(columnDefinition = "TEXT")
    private String fullName;
    @Column(columnDefinition = "TEXT")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_id")
    private List<TestResult> testResults = new ArrayList<>();


    public TestCase(String testCaseId, String fullName, String name) {
        this.testCaseId = testCaseId;
        this.fullName = fullName;
        this.name = name;
    }

    public void addTestResult(TestResult step) {
        testResults.add(step);
    }

    public void removeTestResult(TestResult step) {
        testResults.remove(step);
    }
}
