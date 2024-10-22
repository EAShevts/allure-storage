package ru.eashevts.allure_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.eashevts.allure_storage.entity.TestCase;

import java.util.Optional;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    Optional<TestCase> findByName(String name);

    @Query("SELECT CASE WHEN count(e) > 0 THEN true ELSE false END FROM TestCase as e where e.name = :name")
    boolean existByName(@Param("name") String name);
}