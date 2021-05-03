package com.intocns.Basic.mapper.local;

import com.intocns.Basic.dao.local.BackupFileDao;
import com.intocns.Basic.dao.local.MemberDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public List<BackupFileDao> selectAll();

    // public BackupFileDao selectFile(int idx);

    // public int insertFile(BackupFileDao BackupFileDao);
}
