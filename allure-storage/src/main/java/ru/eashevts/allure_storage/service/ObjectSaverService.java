package ru.eashevts.allure_storage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.dto.BuildReport;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.entity.TestCase;
import ru.eashevts.allure_storage.entity.TestResult;
import ru.eashevts.allure_storage.repository.BuildRunRepository;
import ru.eashevts.allure_storage.repository.TestCaseRepository;

@Service
public class ObjectSaverService {

    @Autowired
    TestCaseRepository testCaseRepository;

    @Autowired
    BuildRunRepository buildRunRepository;


    public TestCase saveTestCaseWithResult(TestResult testResult, BuildRun buildRun){
        testResult.setBuildRun(buildRun);
        if (testCaseRepository.existByName(testResult.getName())) {
            TestCase testCase = testCaseRepository.findByName(testResult.getName());
            testCase.addTestResult(testResult);
            return testCaseRepository.save(testCase);
        } else {
            TestCase testCase = new TestCase(testResult.getTestCaseId(), testResult.getFullName(), testResult.getName());
            testCase.addTestResult(testResult);
            return testCaseRepository.save(testCase);
        }
    }

    public BuildRun saveBuildRun(BuildReport buildReport, String stand, String parameters, String branch){
        return buildRunRepository.save(new BuildRun(buildReport.getBuildName(), buildReport.getBuildUrl(), stand, parameters, branch));
    }

}
