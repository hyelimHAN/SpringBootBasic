package com.hlhan.Basic.dao.local;

import lombok.Data;

@Data
public class BackupFileDao {
    private int idx;
    private int cocode;
    private String file_name;
    private String nas_name;
    private int file_size;
    private String reg_date;
}
