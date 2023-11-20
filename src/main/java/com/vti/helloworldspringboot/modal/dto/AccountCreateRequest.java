package com.vti.helloworldspringboot.modal.dto;

import com.vti.helloworldspringboot.modal.entity.Department;
import lombok.Data;

@Data
public class AccountCreateRequest {
    private String name;
    private String avatar;
    private String address;
    private Department department;

}
