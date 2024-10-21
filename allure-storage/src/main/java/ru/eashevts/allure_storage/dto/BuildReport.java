package ru.eashevts.allure_storage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BuildReport {

    @JsonProperty("buildName")
    private String buildName;

    @JsonProperty("buildOrder")
    private String buildOrder;

    @JsonProperty("reportName")
    private String reportName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("buildUrl")
    private String buildUrl;

    @JsonProperty("reportUrl")
    private String reportUrl;

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;
}
