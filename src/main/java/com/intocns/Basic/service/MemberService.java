package com.intocns.Basic.service;

import com.intocns.Basic.dao.local.MemberDao;
import com.intocns.Basic.mapper.local.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<MemberDao> selectAll() {
        return memberMapper.selectAll();
    }

    public MemberDao selectUser(int user_id) {
        return memberMapper.selectMember(user_id);
    }
}
