package ru.eashevts.allure_storage.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.dto.BuildReport;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.entity.TestCase;
import ru.eashevts.allure_storage.entity.TestResult;
import ru.eashevts.allure_storage.repository.BuildRunRepository;
import ru.eashevts.allure_storage.repository.TestCaseRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ObjectSaverService {

    private final TestCaseRepository testCaseRepository;
    private final BuildRunRepository buildRunRepository;


    public TestCase saveTestCaseWithResult(TestResult testResult, BuildRun buildRun) {
        testResult.setBuildRun(buildRun);
        Optional<TestCase> optionalTestCase = testCaseRepository.findByName(testResult.getName());

        if (optionalTestCase.isPresent()) {
            TestCase testCase = optionalTestCase.get();
            testCase.addTestResult(testResult);
            return testCaseRepository.save(testCase);
        } else {
            TestCase testCase = new TestCase(testResult.getTestCaseId(), testResult.getFullName(), testResult.getName());
            testCase.addTestResult(testResult);
            return testCaseRepository.save(testCase);
        }
    }

    public BuildRun saveBuildRun(BuildReport buildReport, String stand, String params, String branchName) {
        return buildRunRepository.save(new BuildRun(buildReport.getBuildName(), buildReport.getBuildUrl(), stand, params, branchName));
    }

}
