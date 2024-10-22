package ru.eashevts.allure_storage.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.dto.BuildRunDiff;
import ru.eashevts.allure_storage.repository.impl.BuildRunDiffRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildDiffService {

    private final BuildRunDiffRepository buildRunDiffRepository;

    public List<BuildRunDiff> compareBuildRun(Long buildRunMasterId,
                                              Long buildRunSlaveId) {
        return buildRunDiffRepository.findTestResultsComparisonByBuildRuns(buildRunMasterId, buildRunSlaveId);
    }

}
