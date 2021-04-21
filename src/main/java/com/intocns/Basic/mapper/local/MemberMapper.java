package com.intocns.Basic.mapper.local;

import com.intocns.Basic.dao.local.MemberDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDao> selectAll();

    public MemberDao selectMember(int user_id);
}
