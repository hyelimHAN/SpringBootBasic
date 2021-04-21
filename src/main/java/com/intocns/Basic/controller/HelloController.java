package com.intocns.Basic.controller;

import com.intocns.Basic.dto.response.ResponseMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping(value = "/hello/string", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hello/json", method = RequestMethod.GET)
    public ResponseMessageDto helloJson() {
        log.info("hello Json");
        ResponseMessageDto responseMessageDtoDto = new ResponseMessageDto();
        responseMessageDtoDto.setMessage("hello");
        return responseMessageDtoDto;
    }

    @RequestMapping("/ok")
    public ResponseEntity<?> Ok() {
        log.info("ok");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

