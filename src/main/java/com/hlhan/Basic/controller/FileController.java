package com.hlhan.Basic.controller;

import com.hlhan.Basic.constants.ResultConstants;
import com.hlhan.Basic.dao.local.BackupFileDao;
import com.hlhan.Basic.mapper.local.FileMapper;
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
public class FileController extends BaseController{
    @Autowired
    private FileMapper fileMapper;

    @RequestMapping
    public ResponseEntity all(HttpServletRequest request) {
        List<BackupFileDao> files = fileMapper.selectAll();
        return super.makeResponse(ResultConstants.CODE_SUCCESS, files, request);
    }
}
