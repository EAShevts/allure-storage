package ru.eashevts.allure_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eashevts.allure_storage.entity.BuildRun;

public interface BuildRunRepository extends JpaRepository<BuildRun, Long> {
}