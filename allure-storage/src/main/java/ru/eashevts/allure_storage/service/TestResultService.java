package ru.eashevts.allure_storage.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.entity.TestResult;
import ru.eashevts.allure_storage.repository.TestResultRepository;

@Service
public class TestResultService {
    @Autowired
    TestResultRepository resultRepository;



    public TestResult save(TestResult testResult){
        return resultRepository.save(testResult);
    }


    @SneakyThrows
    public TestResult jsonToTestResult(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TestResult.class);
    }

}
