package ru.eashevts.allure_storage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
public class BuildRunDiff {
    Long testCaseId;
    String name;

    Long testResultMasterId;
    String statusMaster;

    Long testResultSlaveId;
    String statusSlave;


    boolean isDiff;

    public BuildRunDiff(Long testCaseId, String name, Long testResultMasterId, String statusMaster, Long testResultSlaveId, String statusSlave) {
        this.testCaseId = testCaseId;
        this.name = name;
        this.testResultMasterId = testResultMasterId;
        this.statusMaster = statusMaster;
        this.testResultSlaveId = testResultSlaveId;
        this.statusSlave = statusSlave;
        this.isDiff = !Objects.equals(statusMaster, statusSlave);
    }
}
