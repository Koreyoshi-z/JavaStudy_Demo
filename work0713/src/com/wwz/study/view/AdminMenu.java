package com.wwz.study.view;

import com.wwz.study.entity.Book;
import com.wwz.study.entity.User;
import com.wwz.study.entity.UserAndBalanceRecordsInfo;
import com.wwz.study.entity.UserAndBookBorrowRecordsInfo;
import com.wwz.study.service.BalanceRecordsService;
import com.wwz.study.service.BookService;
import com.wwz.study.service.BorrowRecordsService;
import com.wwz.study.service.UserService;
import com.wwz.study.service.impl.BalanceRecordsServiceImpl;
import com.wwz.study.service.impl.BookServiceImpl;
import com.wwz.study.service.impl.BorrowRecordsServiceImpl;
import com.wwz.study.service.impl.UserServiceImpl;
import com.wwz.study.util.MyUtil;
import java.util.ArrayList;
import java.util.Scanner;

//管理员界面菜单
public class AdminMenu {
    private Scanner scanner = new Scanner(System.in);
    private String choice;
    private UserService userService = new UserServiceImpl();
    private BalanceRecordsService balanceRecordsService = new BalanceRecordsServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private BorrowRecordsService borrowRecordsService = new BorrowRecordsServiceImpl();

    //管理员主界面
    public void startMenu(){
        while (true){
            System.out.println("=====================欢迎您进入管理员界面=====================");
            System.out.println("1.登录");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    loginMenu();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }


    //管理员登录
    public void loginMenu(){
        //ps：管理员账户是系统开发的时候就设计好的，肯定不能注册。
        System.out.println("======================管理员登录界面======================");
        System.out.println("请输入账户名:");
        String name = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        //我们没有给管理员设计表，这里直接判断即可。
        if (name.equals("admin") && password.equals("123456")) {
            System.out.println("登录成功，正在为您跳转...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            adminLoginSuccessMenu();
        }else {
            System.out.println("登录失败");
            System.out.println("输入'y'继续登录...输入任意其他字符返回管理员主界面");
            choice = scanner.next();
            if (choice.equals("y")){
                loginMenu();
            }
        }
    }


    //管理员成功登录后的功能菜单
    public void adminLoginSuccessMenu(){
        while (true) {
            System.out.println("====================管理员功能界面====================");
            System.out.println("1.所有用户信息");
            System.out.println("2.所有用户的订单记录");
            System.out.println("3.充值排行榜");
            System.out.println("4.图书管理");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    selectAllUserInfo();
                    break;
                case "2":
                    selectAllBalanceRecords();
                    break;
                case "3":
                    rechargeLeaderboard();
                    break;
                case "4":
                    adminBookManagerMenu();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    //1.查看所有用户信息
    public void selectAllUserInfo(){
        ArrayList<User> al = userService.selectAllUserInfo();
        if (al.isEmpty()){
            System.out.println("没有用户信息");
        }else {
            MyUtil.showList(al,"所有用户信息");
        }
    }

    //2.查看所有用户的订单记录
    public void selectAllBalanceRecords(){
        ArrayList<UserAndBalanceRecordsInfo> al = balanceRecordsService.selectAllBalanceRecordsInfo();
        if (al.isEmpty()){
            System.out.println("没有用户的订单记录");
        }else {
            MyUtil.showList(al,"所有用户的订单记录");
        }
    }

    //3.充值排行榜
    public void rechargeLeaderboard(){
        ArrayList<String> al = balanceRecordsService.selectRechargeLeaderboard();
        if (al.isEmpty()){
            System.out.println("排行榜没有记录");
        }else {
            MyUtil.showList(al,"充值排行榜前10位");
        }
    }

    //4.管理员的图书管理菜单
    public void adminBookManagerMenu(){
        while (true) {
            System.out.println("====================管理员图书管理界面====================");
            System.out.println("1.查看所有图书信息");
            System.out.println("2.查看图书借阅信息");
            System.out.println("3.添加图书");
            System.out.println("4.删除图书");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    selectAllBookInfo();
                    break;
                case "2":
                    selectBookBorrowInfo();
                    break;
                case "3":
                    addBook();
                    break;
                case "4":
                    removeBook();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }


    //查看所有图书信息
    public void selectAllBookInfo(){
        ArrayList<Book> al = bookService.selectAllBook();
        if (al.isEmpty()){
            System.out.println("没有图书信息！");
        }else {
            MyUtil.showList(al,"所有图书信息");
        }
    }

    //查看所有的图书借阅信息
    public void selectBookBorrowInfo(){
        ArrayList<UserAndBookBorrowRecordsInfo> al = borrowRecordsService.selectBookBorrowInfo();
        if (al.isEmpty()){
            System.out.println("没有任何图书借阅信息");
        }else {
            MyUtil.showList(al,"所有图书的借阅信息");
        }
    }

    //添加图书
    public void addBook(){
        System.out.println("请输入书名:");
        String name = scanner.next();
        System.out.println("请输入作者名:");
        String author = scanner.next();
        System.out.println("请输入简要的描述:");
        String des = scanner.next();
        System.out.println("请输入价格:");
        Double price = scanner.nextDouble();
        //状态(status)默认是空闲,不需要输入
        Book book = new Book(0, name, author, des, price, "空闲");
        int result = bookService.addBook(book);
        if (result == -1){
            System.out.println("请输入正确的图书信息！");
        }
        if (result == -2){
            System.out.println("该图书已经存在，不能在添加相同名字的书籍！");
        }
        if (result == 1){
            System.out.println("添加成功！");
        }
    }

    //删除图书
    public void removeBook(){
        System.out.println("请输入您要删除的图书名:");
        String name = scanner.next();
        int result = bookService.removeBook(name);
        if (result == -1){
            System.out.println("不存在该图书，删除失败！");
        }
        if (result == 1){
            System.out.println("删除成功！");
        }
    }

}
