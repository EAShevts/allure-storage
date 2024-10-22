package ru.eashevts.allure_storage.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.eashevts.allure_storage.dto.BuildRunDiff;
import ru.eashevts.allure_storage.entity.TestResult;

import java.util.List;
import java.util.Objects;

@Repository
public interface BuildRunDiffRepository extends JpaRepository<TestResult, Long> {
    @Query("""
            SELECT
            new ru.eashevts.allure_storage.dto.BuildRunDiff(
                tr1.testCase.id,
                tr1.name,
                tr1.id,
                tr1.status,
                tr2.id,
                tr2.status
            )
            FROM TestResult tr1
            JOIN TestResult tr2 ON tr1.testCase = tr2.testCase
                        
            WHERE tr1.buildRun.id = :buildRunMasterId AND tr2.buildRun.id = :buildRunSlaveId
            """)
    List<BuildRunDiff> findTestResultsComparisonByBuildRuns(
            @Param("buildRunMasterId") Long buildRunMasterId,
            @Param("buildRunSlaveId") Long buildRunSlaveId);

}
