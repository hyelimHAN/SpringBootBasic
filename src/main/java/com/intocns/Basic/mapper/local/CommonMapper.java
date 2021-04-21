package com.intocns.Basic.mapper.local;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonMapper {
    public List<Map> getAll();
}
