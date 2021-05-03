package com.intocns.Basic.mapper.local;

import com.intocns.Basic.dao.local.AuthDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AuthMapper {
    public AuthDao readUser(@Param("username") String username);

    public List<String> readAuthority(@Param("username") String username);
}
