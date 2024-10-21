package ru.eashevts.allure_storage.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.eashevts.allure_storage.dto.BuildReport;

@Service
public class TestRunService {

    @SneakyThrows
    public BuildReport jsonToTestBuildReport(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, BuildReport.class);
    }

}
