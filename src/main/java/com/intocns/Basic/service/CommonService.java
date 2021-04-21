package com.intocns.Basic.service;

import com.intocns.Basic.mapper.local.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonService {
    @Autowired
    private CommonMapper commonMapper;

    public List<Map> getAll() {
        List<Map> total = commonMapper.getAll();
        return total;
    }
}
