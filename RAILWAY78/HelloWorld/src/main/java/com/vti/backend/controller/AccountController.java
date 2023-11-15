package com.vti.backend.controller;

import com.vti.backend.service.AccountService;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    AccountService service = new AccountService();

    public List<Account> getAllAccount() throws SQLException {
        return service.getAllAccount();
    }

    public Account findById(int id) throws SQLException {
        return service.findById(id);
    }

    public Account findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    public void createAccount(Account account) throws SQLException {
        service.createAccount(account);
    }

    public void updateAccount(Account account) throws SQLException {
        service.updateAccount(account);
    }

    public void deleteAccount(int id) {
        service.deleteAccount(id);
    }
}
