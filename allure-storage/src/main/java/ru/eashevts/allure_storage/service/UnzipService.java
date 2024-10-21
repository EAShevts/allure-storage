package ru.eashevts.allure_storage.service;


import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

@Service
public class UnzipService {


    public String readJsonFile(ZipInputStream zis) throws Exception {
        StringBuilder jsonContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(zis));
        String line;

        while ((line = reader.readLine()) != null) {
            jsonContent.append(line);
        }

        return jsonContent.toString();
    }

}
