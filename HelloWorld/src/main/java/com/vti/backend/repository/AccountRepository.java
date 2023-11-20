package com.vti.backend.repository;

import com.vti.entity.Account;
import com.vti.entity.Role;
import com.vti.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    public List<Account> getAllAccount() throws SQLException {
        String sql = "SELECT * FROM JDBC.Account";
        // Chuẩn bị sẵn 1 stament ( câu lệnh )
        Statement statement = JdbcUtils.getConnect().createStatement();
        // execute câu lệnh SQL
        ResultSet resultSet = statement.executeQuery(sql);
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            // Lấy các giá trị được trả về
            int id = resultSet.getInt("Id");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");
            String email = resultSet.getString("email");
            // Set các giá trị cho user
            Account account = new Account();
            account.setId(id);
            account.setUsername(username);
            account.setRole(Role.valueOf(role));
            account.setEmail(email);
            // Gán đối tượng user vào list
            accounts.add(account);
        }
        JdbcUtils.closeConnection();
        return accounts;
    }

    public void createAccount(Account account) throws SQLException {
        var accountCheck = findByName(account.getUsername());
        if (accountCheck != null) {
            System.err.println("User name đã tồn tại!");
            return;
        }
        String sql = "insert into Account (username, email, password,first_name,last_name, role) " +
                "values( ? , ? , ? , ? , ?, ? );";
        // Chuẩn bị sẵn 1 stament ( câu lệnh )
        PreparedStatement statement = JdbcUtils.getConnect().prepareStatement(sql);
        // execute câu lệnh SQL
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getEmail());
        statement.setString(3, account.getPassword());
        statement.setString(4, account.getFirstName());
        statement.setString(5, account.getLastName());
        statement.setString(6, Role.EMPLOYEE.name());
        int rs = statement.executeUpdate();
        JdbcUtils.closeConnection();
        if (rs > 0) {
            System.out.println("Thêm mới thành công!");
        } else {
            System.err.println("Thêm mới thất bại!");
        }
    }

    public void updateAccount(Account account) throws SQLException {
        var accountCheck = findById(account.getId());
        if (accountCheck == null) {
            System.err.println("Id nhập vào ko tồn tại!");
            return;
        }
        String sql = "UPDATE `JDBC`.`Account` SET `password` = ?, `first_name` = ?, `last_name` = ? " +
                "WHERE (`id` = ?);";
        PreparedStatement statement = JdbcUtils.getConnect().prepareStatement(sql);
        statement.setString(1, account.getPassword());
        statement.setString(2, account.getFirstName());
        statement.setString(3, account.getLastName());
        statement.setInt(4, account.getId());
        int rs = statement.executeUpdate();
        JdbcUtils.closeConnection();
        if (rs > 0) {
            System.out.println("Update thành công!");
        } else {
            System.err.println("Update thất bại!");
        }
    }

    public Account findById(int id) throws SQLException {
        String sql = "Select * from JDBC.Account where id = ?";
        PreparedStatement preparedStatement = JdbcUtils.getConnect().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        // execute câu lệnh SQL
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();

        if (resultSet.next()) {
            account.setId(id);
            // Set giá trị user Name
            String username = resultSet.getString("username");
            account.setUsername(username);
            account.setEmail(resultSet.getString("email"));
            account.setFirstName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            String roleString = resultSet.getString("role");
            account.setRole(Role.valueOf(roleString));
        } else {
            return null;
        }
        JdbcUtils.closeConnection();
        return account;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM `JDBC`.`Account` WHERE (`id` = ?);";
        PreparedStatement statement = null;
        try {
            statement = JdbcUtils.getConnect().prepareStatement(sql);
            statement.setInt(1, id);
            int rs = statement.executeUpdate();
            JdbcUtils.closeConnection();
            if (rs > 0) {
                System.out.println("Update thành công!");
            } else {
                System.err.println("Update thất bại!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Account findByName(String name) throws SQLException {
        String sql = "Select * from JDBC.Account where username = ?";
        PreparedStatement preparedStatement = JdbcUtils.getConnect().prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if (resultSet.next()) {
            // Set giá trị user Name
            String username = resultSet.getString("username");
            account.setId(resultSet.getInt("id"));
            account.setUsername(username);
            account.setFirstName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            String roleString = resultSet.getString("role");
            account.setRole(Role.valueOf(roleString));
        } else {
            return null;
        }
        JdbcUtils.closeConnection();
        return account;
    }
}
