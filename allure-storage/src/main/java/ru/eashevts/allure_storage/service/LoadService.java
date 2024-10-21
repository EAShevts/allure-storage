package ru.eashevts.allure_storage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.dto.BuildReport;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.entity.TestResult;

@Service
public class LoadService {

    @Autowired
    ObjectSaverService objectSaverService;
    @Autowired
    TestResultService testResultService;

    @Autowired
    TestRunService testRunService;


    public void saveTestResult(String tr, BuildRun buildRun) {
        TestResult testResult = testResultService.jsonToTestResult(tr);
        objectSaverService.saveTestCaseWithResult(testResult, buildRun);
    }
    public BuildRun saveBuildRun(String buildReportStr, String stand, String parameters, String branch) {
        BuildReport buildReport = testRunService.jsonToTestBuildReport(buildReportStr);

        return objectSaverService.saveBuildRun(buildReport, stand, parameters, branch);
    }

}
