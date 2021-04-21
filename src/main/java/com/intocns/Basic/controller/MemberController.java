package com.intocns.Basic.controller;

import com.intocns.Basic.Constants.ResultConstants;
import com.intocns.Basic.component.MessageComponent;
import com.intocns.Basic.dao.local.MemberDao;
import com.intocns.Basic.dto.request.member.AddMemberDto;
import com.intocns.Basic.dto.response.ResponseResultObject;
import com.intocns.Basic.service.MemberService;
import com.intocns.Basic.util.ApiUtil;
import com.sun.tools.javac.util.DefinedBy;
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
    MemberService memberService;
    @Autowired
    MessageComponent messageComponent;

    @RequestMapping
    public ResponseEntity all(HttpServletRequest request) {
        List<MemberDao> members = memberService.selectAll();
        ResponseResultObject result = new ResponseResultObject(ResultConstants.CODE_SUCCESS,
                messageComponent.getMessage("response.success"), members);
        return ApiUtil.makeResponse(request, HttpStatus.OK, result);
    }

    @RequestMapping("/{id}")
    public @ResponseBody Object get(HttpServletRequest request, @PathVariable("id") int id) {
        MemberDao member = memberService.selectUser(id);
        ResponseResultObject result = new ResponseResultObject();
        result.setCode(ResultConstants.CODE_SUCCESS);
        result.setMessage(messageComponent.getMessage("response.success"));
        result.setData(member);
        return ApiUtil.makeResponse(request, HttpStatus.OK, result);
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public ResponseEntity addMember(HttpServletRequest request, @RequestBody @Valid AddMemberDto addMemberDto) {
        log.info(addMemberDto.toString());
        try {
            MemberDao memberDao = new MemberDao();
            memberDao.setId(addMemberDto.getId());
            memberDao.setName(addMemberDto.getName());
            memberDao.setPassword(addMemberDto.getPassword());

            memberService.insertMember(memberDao);
            ResponseResultObject result = new ResponseResultObject(ResultConstants.CODE_SUCCESS,
                    messageComponent.getMessage("response.success"));
            return ApiUtil.makeResponse(request, HttpStatus.OK, result);
        } catch (Exception e) {
            log.warn(e.getMessage());
            ResponseResultObject result = new ResponseResultObject(ResultConstants.CODE_FAIL,
                    messageComponent.getMessage("response.fail"));
            return ApiUtil.makeResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, result);
        }
    }

}
