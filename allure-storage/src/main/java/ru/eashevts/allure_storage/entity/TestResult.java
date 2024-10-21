package ru.eashevts.allure_storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "test_results")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String historyId;
    @Column(columnDefinition = "TEXT")
    private String testCaseId;
    @Column(columnDefinition = "TEXT")
    private String fullName;
    @Column(columnDefinition = "TEXT")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_result_id")
    private List<Link> links;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_result_id")
    private List<Label> labels;

    private String status;
    private Long start;
    private Long stop;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_result_id")
    private List<Step> steps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_run_id" )
    private BuildRun buildRun;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestCase testCase;

}