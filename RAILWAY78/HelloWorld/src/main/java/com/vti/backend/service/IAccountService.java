package com.vti.backend.service;

import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> getAllAccount() throws SQLException;

    Account findById(int id) throws SQLException;

    void createAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    Account findByName(String name) throws SQLException;

    void deleteAccount(int id);
}
