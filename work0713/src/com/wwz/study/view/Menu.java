package com.wwz.study.view;

import java.util.Scanner;

//主菜单  管理者和用户
public class Menu {
private Scanner scanner = new Scanner(System.in);
private String choice;
private UserMenu userMenu = new UserMenu();
private AdminMenu adminMenu = new AdminMenu();

    //系统主菜单
    public void mainMenu() throws InterruptedException {
        while (true){
            System.out.println("======================图书馆里系统======================");
            System.out.println("1.管理员界面");
            System.out.println("2.用户界面");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    adminMenu.startMenu();//管理员主界面
                    break;
                case "2":
                    userMenu.startMenu();//用户主界面
                    break;
                case "0":
                    return;//退出程序
                default:
                    break;
            }
        }
    }
}
