package com.vti.backend.repository;

import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    List<Account> getAllAccount() throws SQLException;

    void createAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    Account findById(int id) throws SQLException;

    void deleteById(int id);

    Account findByName(String name) throws SQLException;
}
