package com.intocns.Basic.controller;

import com.intocns.Basic.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1/common")
public class CommonController {
    @Autowired
    CommonService commonService;

    @RequestMapping("/all")
    public ResponseEntity<List> selectAll() {
        return new ResponseEntity<>(commonService.getAll(), HttpStatus.OK);
    }
}
