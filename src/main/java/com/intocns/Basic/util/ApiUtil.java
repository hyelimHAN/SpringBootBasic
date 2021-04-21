package com.intocns.Basic.util;

import com.intocns.Basic.dto.response.ResponseResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

@Slf4j
public class ApiUtil {

    public static ResponseEntity makeResponse(HttpServletRequest request, HttpStatus httpStatus, ResponseResultObject ro) {

        ro.setTimeStamp(new Timestamp(new Date().getTime()));
        ro.setPath(request.getRequestURI());
        ro.setStatus(httpStatus.value());

        return new ResponseEntity<>(ro, httpStatus);
    }

    public static void writeExcetpionLog(Exception e) {
        //final String username = SecurityContextHolder.getContext().getAuthentication().getName();

        StringWriter writer = new StringWriter();
        PrintWriter printWriter= new PrintWriter(writer);
        e.printStackTrace(printWriter);
        // log.error("coCode - " + username + " :: " + writer.toString());
    }
}
