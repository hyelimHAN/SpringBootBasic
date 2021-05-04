package com.hlhan.Basic.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
public class ResponseResultObject {
    private Timestamp timeStamp;
    private int status;
    private String code; // API 자체 코드
    private String message;
    private Object data;
    private String path;
    private String trace;

    public ResponseResultObject() {
    }

    public ResponseResultObject(String code, String message, String path) {
        this.code = code;
        this.message = message;
        this.path = path;
    }

    public ResponseResultObject(String code, String message, Object data, String path) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.path = path;
    }

    public ResponseResultObject(String code, String message, String trace, String path) {
        this.code = code;
        this.message = message;
        this.trace = trace;
        this.path = path;
    }
}
