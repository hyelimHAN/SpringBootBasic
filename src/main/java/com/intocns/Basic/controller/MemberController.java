package com.intocns.Basic.controller;

import com.intocns.Basic.Constants.ResultConstants;
import com.intocns.Basic.dao.local.MemberDao;
import com.intocns.Basic.dto.response.ResultObject;
import com.intocns.Basic.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping
    public ResponseEntity all() {
        List<MemberDao> members = memberService.selectAll();
        ResultObject result = new ResultObject();
        result.setCode(ResultConstants.CODE_SUCCESS);
        result.setMsg(ResultConstants.MESSAGE_SUCCESS);
        result.setData(members);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public @ResponseBody Object get(@PathVariable("id") int id) {
        MemberDao member = memberService.selectUser(id);
        ResultObject result = new ResultObject();
        result.setCode(ResultConstants.CODE_SUCCESS);
        result.setMsg(ResultConstants.MESSAGE_SUCCESS);
        result.setData(member);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
