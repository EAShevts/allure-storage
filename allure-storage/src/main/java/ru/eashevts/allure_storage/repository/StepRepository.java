package ru.eashevts.allure_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eashevts.allure_storage.entity.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}