package ru.eashevts.allure_storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.eashevts.allure_storage.entity.BuildRun;

public interface BuildRunRepository extends PagingAndSortingRepository<BuildRun, Long>, CrudRepository<BuildRun, Long> {

}