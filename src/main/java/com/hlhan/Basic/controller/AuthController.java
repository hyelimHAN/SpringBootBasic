package com.hlhan.Basic.controller;

import com.hlhan.Basic.constants.ResultConstants;
import com.hlhan.Basic.component.MessageComponent;
import com.hlhan.Basic.dto.request.member.LoginDto;
import com.hlhan.Basic.dto.response.ResponseResultObject;
import com.hlhan.Basic.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    @Value("${spring.session.maxInactiveInterval}")
    private int maxInactiveInterval;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(final HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                @RequestBody @Valid LoginDto loginDto) {

        try {
            final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginDto.getCoCode(), loginDto.getPassword());

            final Authentication authentication = this.authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            request.getSession().setMaxInactiveInterval(maxInactiveInterval);

            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return ApiUtil.makeResponse(ResultConstants.CODE_SUCCESS, request);
        }
        catch (Exception e) {
            ApiUtil.writeExcetpionLog(e);
            return ApiUtil.makeHttpCodeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }
}
