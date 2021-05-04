package com.hlhan.Basic.mapper.local;

import com.hlhan.Basic.dao.local.BackupFileDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public List<BackupFileDao> selectAll();

    // public BackupFileDao selectFile(int idx);

    // public int insertFile(BackupFileDao BackupFileDao);
}
