package com.hlhan.Basic.controller;

import com.hlhan.Basic.constants.ResultConstants;
import com.hlhan.Basic.component.MessageComponent;
import com.hlhan.Basic.dao.local.BackupFileDao;
import com.hlhan.Basic.dto.response.ResponseResultObject;
import com.hlhan.Basic.mapper.local.FileMapper;
import com.hlhan.Basic.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileMapper fileMapper;

    @RequestMapping
    public ResponseEntity all(HttpServletRequest request) {
        List<BackupFileDao> files = fileMapper.selectAll();
        return ApiUtil.makeResponse(ResultConstants.CODE_SUCCESS, files, request);
    }
}
