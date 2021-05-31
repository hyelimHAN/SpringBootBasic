package com.hlhan.Basic.util;

import com.hlhan.Basic.component.MessageComponent;
import com.hlhan.Basic.dto.response.ResponseResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

@Slf4j
public class ApiUtil {

    @Autowired
    private static MessageComponent messageComponent;

    public static ResponseEntity makeResponse(String responseCode, HttpServletRequest request) {
        ResponseResultObject ro = new ResponseResultObject();
        ro.setCode(responseCode);
        ro.setMessage(messageComponent.getMessage(responseCode));
        ro.setPath(request.getRequestURI());
        ro.setTimeStamp(new Timestamp(new Date().getTime()));
        ro.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(ro, HttpStatus.OK);
    }

    public static ResponseEntity makeResponse(String responseCode, Object responseData, HttpServletRequest request) {
        ResponseResultObject ro = new ResponseResultObject();
        ro.setCode(responseCode);
        ro.setMessage(messageComponent.getMessage(responseCode));
        ro.setData(responseData);
        ro.setPath(request.getRequestURI());
        ro.setTimeStamp(new Timestamp(new Date().getTime()));
        ro.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(ro, HttpStatus.OK);
    }

    public static ResponseEntity makeHttpCodeResponse(HttpStatus httpStatus) {
        ResponseResultObject ro = new ResponseResultObject();

        ro.setTimeStamp(new Timestamp(new Date().getTime()));
        ro.setStatus(httpStatus.value());

        return new ResponseEntity<>(ro, httpStatus);
    }

    public static ResponseEntity makeHttpCodeResponse(HttpStatus httpStatus, String msg) {
        ResponseResultObject ro = new ResponseResultObject();

        ro.setTimeStamp(new Timestamp(new Date().getTime()));
        ro.setStatus(httpStatus.value());
        ro.setMessage(msg);

        return new ResponseEntity<>(ro, httpStatus);
    }

    public static void writeErrorLog(String err) {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.error("coCode - {} :: {}", username,  err);
    }

    public static void writeExcetpionLog(Exception e) {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();

        StringWriter writer = new StringWriter();
        PrintWriter printWriter= new PrintWriter(writer);
        e.printStackTrace(printWriter);
        log.error("coCode - {} :: {}", username,  writer.toString());
    }
}
