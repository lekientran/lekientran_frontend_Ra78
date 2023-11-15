package com.vti.frontEnd;

import com.vti.backend.controller.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Role;
import com.vti.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class Function {
    AccountController controller = new AccountController();

    public void getAllAccount() throws SQLException {
        List<Account> accounts = controller.getAllAccount();
        if (accounts.size() > 0){

            String leftAlignFormat = "| %-3s| %-20s | %-20s | %-20s |%n";
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
            System.out.format("| id |      FullName        |        Email         |         Role         |%n");
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
            for (Account account : accounts) {
                System.out.format(leftAlignFormat,account.getId(), account.getUsername(),account.getEmail(), account.getRole());
            }
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
        } else {
            System.out.println("Danh sách account rỗng");
        }
    }

    public void createAccount() throws SQLException {
        System.out.println("Mời bạn nhập vào tên!");
        String name = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập vào email!");
        String email = ScannerUtils.inputEmail();

        System.out.println("Mời bạn nhập vào pass!");
        String pass = ScannerUtils.inputPasswords();

        System.out.println("Mời bạn nhập vào firstName!");
        String firstName = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập vào lastName!");
        String lastName = ScannerUtils.inputString();

        Account account = new Account();
        account.setUsername(name);
        account.setEmail(email);
        account.setPassword(pass);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setRole(Role.EMPLOYEE);
        controller.createAccount(account);
    }

    public void updateAccount() throws SQLException {
        System.out.println("Mời bạn nhập vào id muốn update!");
        int id = ScannerUtils.inputIntPositive();

        System.out.println("Mời bạn nhập vào pass mới!");
        String pass = ScannerUtils.inputPasswords();

        System.out.println("Mời bạn nhập vào firstName!");
        String firstName = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập vào lastName!");
        String lastName = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập vào email!");
        String email = ScannerUtils.inputEmail();

        Account account = controller.findById(id);
        account.setId(id);
        account.setPassword(pass);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);

        controller.updateAccount(account);
    }

    public void findByName() throws SQLException {
        System.out.println("Mời bạn nhập vào tên cần tìm kiếm!");
        String name = ScannerUtils.inputString();
        Account account = controller.findByName(name);
        if (account == null){
            System.out.println("Account không tồn tại!");
        } else {
            System.out.println(account);
        }
    }
    public void getById() throws SQLException {
        System.out.println("Mời bạn nhập vào ID cần tìm kiếm!");
        int id = ScannerUtils.inputIntPositive();
        Account account = controller.findById(id);
        if (account == null){
            System.out.println("Account không tồn tại!");
        } else {
            String leftAlignFormat = "| %-3s| %-20s | %-20s | %-20s |%n";
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
            System.out.format("| id |      FullName        |        Email         |         Role         |%n");
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
            System.out.format(leftAlignFormat,account.getId(), account.getUsername(),account.getEmail(), account.getRole());
            System.out.format("+----+----------------------+----------------------+----------------------+%n");
        }
    }

    public void deleteById(){
        System.out.println("Mời bạn nhập vào ID cần tìm kiếm!");
        int id = ScannerUtils.inputIntPositive();
        controller.deleteAccount(id);
    }
}
