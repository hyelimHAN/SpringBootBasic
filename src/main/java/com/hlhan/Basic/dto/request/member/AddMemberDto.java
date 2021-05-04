package com.hlhan.Basic.dto.request.member;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddMemberDto {

    @NotNull(message="{validation.error.notNull}")
    @NotEmpty(message="{validation.error.notEmpty}")
    @Size(min=3, max=10, message="{validation.error.size.range}")
    private String id;

    @NotNull(message="{validation.error.notNull}")
    @NotEmpty(message="{validation.error.notEmpty}")
    private String password;

    @NotNull(message="{validation.error.notNull}")
    @NotEmpty(message="{validation.error.notEmpty}")
    private String name;
}
