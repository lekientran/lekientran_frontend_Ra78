package com.vti.helloworldspringboot.service;

import com.vti.helloworldspringboot.modal.dto.AccountCreateRequest;
import com.vti.helloworldspringboot.modal.dto.AccountUpdateRequest;
import com.vti.helloworldspringboot.modal.entity.Account;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();

    Page<Account> getAllV2(int page, int size);

    Account findById(long id);

    void delete(long id);

    Account create(AccountCreateRequest request);
    Account update(AccountUpdateRequest request);
}
