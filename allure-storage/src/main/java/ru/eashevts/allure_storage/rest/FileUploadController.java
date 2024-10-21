package ru.eashevts.allure_storage.rest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.service.LoadService;
import ru.eashevts.allure_storage.service.UnzipService;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@Slf4j
@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    UnzipService unzipService;

    @Autowired
    LoadService loadService;

    @PostMapping("/upload-zip")
    @SneakyThrows
    public ResponseEntity<Object> uploadZipFile(@RequestParam("file") MultipartFile file,
                                                @RequestParam("stand") String stand,
                                                @RequestParam("parameters") String parameters,
                                                @RequestParam("branch") String branch) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".zip")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload a valid ZIP file.");
        }
        BuildRun buildRun = null;
        try (ZipInputStream zisForBuildRun = new ZipInputStream(file.getInputStream())) {
            ZipEntry zipEntryForBuildRun;

            while ((zipEntryForBuildRun = zisForBuildRun.getNextEntry()) != null) {
                if (zipEntryForBuildRun.getName().endsWith("executor.json")) {
                    String testRunStr = unzipService.readJsonFile(zisForBuildRun);
                    buildRun = loadService.saveBuildRun(testRunStr, stand, parameters, branch);

                }
                zisForBuildRun.closeEntry(); // Закрываем текущий элемент перед переходом к следующему
            }
        } catch ( IOException e) {
            log.info("Error {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the ZIP file: " + e.getMessage());
        }

        try (ZipInputStream zis = new ZipInputStream(file.getInputStream())) {
            ZipEntry zipEntry;

            while ((zipEntry = zis.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith("-result.json")) {
                    String testRunStr = unzipService.readJsonFile(zis);
                    loadService.saveTestResult(testRunStr, buildRun);

                }

                zis.closeEntry(); // Закрываем текущий элемент перед переходом к следующему
            }
        } catch ( IOException e) {
            log.info("Error {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the ZIP file: " + e.getMessage());
        }


        return ResponseEntity.ok("OK");
    }

}