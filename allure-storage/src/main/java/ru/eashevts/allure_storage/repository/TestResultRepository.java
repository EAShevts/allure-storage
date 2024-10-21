package ru.eashevts.allure_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eashevts.allure_storage.entity.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    // Здесь можно добавить дополнительные методы запросов, если потребуется
}