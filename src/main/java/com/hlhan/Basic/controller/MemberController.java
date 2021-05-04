package com.hlhan.Basic.controller;

import com.hlhan.Basic.Constants.ResultConstants;
import com.hlhan.Basic.component.MessageComponent;
import com.hlhan.Basic.dto.request.member.AddMemberDto;
import com.hlhan.Basic.mapper.local.MemberMapper;
import com.hlhan.Basic.dao.local.MemberDao;
import com.hlhan.Basic.dto.response.ResponseResultObject;
import com.hlhan.Basic.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    MessageComponent messageComponent;

    @RequestMapping
    public ResponseEntity all(HttpServletRequest request) {
        List<MemberDao> members = memberMapper.selectAll();
        ResponseResultObject result = new ResponseResultObject(ResultConstants.CODE_SUCCESS,
                messageComponent.getMessage("response.success"), members, request.getRequestURI());
        return ApiUtil.makeResponse(result);
    }

    @RequestMapping("/{id}")
    public @ResponseBody Object get(HttpServletRequest request, @PathVariable("id") int id) {
        try {
            MemberDao member = memberMapper.selectMember(id);
            ResponseResultObject result = new ResponseResultObject(
                    ResultConstants.CODE_SUCCESS, messageComponent.getMessage("response.success"), member,
                    request.getRequestURI());
            return ApiUtil.makeResponse(result);
        } catch (Exception e) {
            log.warn("##### RequestURI : {} , Error Message : {}", request.getRequestURI(), e.getMessage());
            return ApiUtil.makeHttpCodeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public ResponseEntity addMember(HttpServletRequest request, @RequestBody @Valid AddMemberDto addMemberDto) {
        try {
            MemberDao memberDao = new MemberDao();
            memberDao.setId(addMemberDto.getId());
            memberDao.setName(addMemberDto.getName());
            memberDao.setPassword(addMemberDto.getPassword());

            memberMapper.insertMember(memberDao);
            ResponseResultObject result = new ResponseResultObject(ResultConstants.CODE_SUCCESS,
                    messageComponent.getMessage("response.success"), request.getRequestURI());
            return ApiUtil.makeResponse(result);
        } catch (Exception e) {
            log.warn("##### RequestURI : {} , Error Message : {}", request.getRequestURI(), e.getMessage());
            return ApiUtil.makeHttpCodeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
