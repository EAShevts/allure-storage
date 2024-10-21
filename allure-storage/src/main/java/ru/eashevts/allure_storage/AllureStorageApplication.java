package ru.eashevts.allure_storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
//		exclude = {
//		DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class
//		}
)
public class AllureStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllureStorageApplication.class, args);
	}

}
