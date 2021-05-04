package com.hlhan.Basic.dto.request.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @NotNull(message="{validation.error.notNull}")
    @NotEmpty(message="{validation.error.notEmpty}")
    @Size(min=3, max=4, message="{validation.error.size.range}")
    private String coCode;

    @NotNull(message="{validation.error.notNull}")
    @NotEmpty(message="{validation.error.notEmpty}")
    @Size(min=12, message="{validation.error.size.min}")
    private String password;
}
