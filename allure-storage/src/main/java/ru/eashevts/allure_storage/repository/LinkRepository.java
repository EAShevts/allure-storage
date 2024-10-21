package ru.eashevts.allure_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eashevts.allure_storage.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}