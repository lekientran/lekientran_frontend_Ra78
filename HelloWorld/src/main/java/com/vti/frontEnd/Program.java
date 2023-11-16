package com.vti.frontEnd;

import com.vti.backend.repository.AccountRepository;
import com.vti.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        int menu;
        Function function = new Function();
        while (true) {
            System.out.println("------------------------- MENU -----------------------");
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Danh sách Account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Tìm kiếm Account theo id");
            System.out.println("4. Update account");
            System.out.println("5. Xoá Account theo Id");
            System.out.println("6. Thoát");

            menu = ScannerUtils.inputNumber(1,6);
            switch (menu) {
                case 1:
                    function.getAllAccount();
                    break;
                case 2:
                    function.createAccount();
                    break;
                case 3:
                    function.getById();
                    break;
                case 4:
                    function.updateAccount();
                    break;
                case 5:
                    function.deleteById();
                    break;
                case 6:
                    return;
            }
        }
    }
}
