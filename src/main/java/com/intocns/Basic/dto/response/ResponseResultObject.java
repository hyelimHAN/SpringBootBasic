package com.intocns.Basic.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
public class ResponseResultObject {
    @JsonProperty("timeStamp")
    private Timestamp timeStamp;
    @JsonProperty("status")
    private int status;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("path")
    private String path;

    public ResponseResultObject() {
    }

    public ResponseResultObject(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResultObject(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
