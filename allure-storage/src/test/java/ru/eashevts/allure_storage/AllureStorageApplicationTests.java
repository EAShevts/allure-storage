//package ru.eashevts.allure_storage;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static ru.eashevts.allure_storage.utils.DataUidGenerator.generateDataUid;
//
//@SpringBootTest
//class AllureStorageApplicationTests {
//
//	@Test
//	void contextLoads() {
//
//		String uuid = "d7c7aa91-35ae-417f-9b22-03f573fe225d";
//		String historyId = "463f2da5ffd17eb23b9fd70bb81e610f";
//		String testCaseId = "[engine:junit-platform-suite]/[suite:ru.vtb.geleautoqa.suites.FeSuite]/[engine:junit-jupiter]/[class:ru.vtb.geleautoqa.tests.front.reporting.ReportingTest]/[method:checkingTheUploadingOfTransactionInformationToAFile()]";
//		String testCaseName = "GELE-10 Проверка выгрузки информации по проводкам в файл формата \".xlsx\"";
//		String fullName = "ru.vtb.geleautoqa.tests.front.reporting.ReportingTest.checkingTheUploadingOfTransactionInformationToAFile";
//
//		// Генерируем data-uid
//		String dataUid = generateDataUid(uuid, historyId, testCaseId, testCaseName, fullName);
//		System.out.println("Сгенерированный data-uid: " + dataUid);
//	}
//
//}
