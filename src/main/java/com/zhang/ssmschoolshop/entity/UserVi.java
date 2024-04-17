package com.zhang.ssmschoolshop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVi extends User{
    private String originPsw;
}
