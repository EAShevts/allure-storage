package ru.eashevts.allure_storage.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "build_runs")
public class BuildRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String stand;

    private String buildUrl;

    private String branch;

    private String parameters;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "build_run_id")
    private List<TestResult> testResults = new ArrayList<>();

    public BuildRun(String buildName, String buildUrl, String stand, String parameters, String branch) {
        this.name = buildName;
        this.stand = stand;
        this.buildUrl = buildUrl;
        this.parameters = parameters;
        this.branch = branch;
    }


    public void addTestResult(TestResult testResult) {
        testResults.add(testResult);
        testResult.setBuildRun(this); // Установка обратной ссылки
    }

    public void removeTestResult(TestResult testResult) {
        testResults.remove(testResult);
        testResult.setBuildRun(null); // Установка обратной ссылки в null
    }
}
