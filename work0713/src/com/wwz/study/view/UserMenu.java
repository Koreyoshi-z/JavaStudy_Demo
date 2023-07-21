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

//用户界面菜单(包括注册、登录等功能)
public class UserMenu {
    private Scanner scanner = new Scanner(System.in);
    private String choice;
    private UserService userService = new UserServiceImpl();//获取用户业务逻辑操作权限
    private int user_id;//记录当前登录账号的id
    private BalanceRecordsService balanceRecordsService = new BalanceRecordsServiceImpl();//获取余额记录业务逻辑操作权限
    private BookService bookService = new BookServiceImpl();//获取图书业务逻辑操作权限
    private BorrowRecordsService borrowRecordsService = new BorrowRecordsServiceImpl();//获取图书借阅记录业务逻辑操作权限


    //用户主界面
    public void startMenu() throws InterruptedException {
        while (true){
            System.out.println("=====================欢迎您进入用户界面=====================");
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    registerMenu();
                    break;
                case "2":
                    loginMenu();
                    break;
                case "0":
                    return;//返回上一级
                default:
                    break;
            }
        }
    }


    //注册功能
    public void registerMenu() throws InterruptedException {
        while (true){
            System.out.println("======================注册界面======================");
            System.out.println("请输入账户名:");
            String name = scanner.next();
            System.out.println("请输入密码:");
            String password = scanner.next();
            User user = new User(0,name,password,0,0);//接收用户输入的信息
            //register()方法是Boolean类型，返回true则方法执行成功，返回false则失败。
            if (userService.register(user)){
                System.out.println("注册成功");
                System.out.println("现在为您跳转到登录界面......");
                Thread.sleep(2000);//休眠3秒，模拟跳转登录操作。 PS: 加个sleep更合适吧
                loginMenu();
                return;
            }else {
                System.out.println("账户已存在，注册失败！");
                System.out.println("您是否继续注册？......输入n继续...");
                choice = scanner.next();
                if (choice.equals("n")){
                    break;//跳出次循环进入while循环
                }
            }
        }
    }


    //登录功能
    public void loginMenu() throws InterruptedException {
        int count = 0;//记录登录失败的次数
        while (true){
            System.out.println("======================用户登录界面======================");
            System.out.println("请输入账号:");
            String name = scanner.next();
            System.out.println("请输入密码:");
            String password = scanner.next();
            User user = new User(0, name, password, 0, 0);

            int result = userService.login(user);//返回登录的结果
            if (userService.login(user) == 1){
                System.out.println("登录成功，正在为您跳转到用户功能界面......");
                user_id = userService.selectByName(name).getId();//保存登录成功后的当前账号的id
                Thread.sleep(2000);
                userLoginSuccessMenu();
            }else {
                if (result == -1){
                    System.out.println("该账号不存在!");
                    System.out.println("输入'y'注册新账号...输入任意其他字符返回登录界面");
                    choice = scanner.next();
                    if (choice.equals("y")){
                        registerMenu();//跳转到注册界面，比较人性化
                    }
                }
                if (result == -2){
                    count++;//这里是只有密码错误，才会减少登录次数，账号输入错误不算count次数
                    System.out.println("密码错误，您还有" +(3-count)+"次机会，请重新输入:");
                }
                if (count == 3){//密码输入3次直接GG
                    System.out.println("多次登录失败，您的账号已被冻结......");
                    System.exit(0);//终止虚拟机，退出你的Java程序。
                }
            }
        }
    }


    //用户登录成功后的功能菜单
    public void userLoginSuccessMenu() throws InterruptedException {
        while (true){
            System.out.println("====================用户的个人功能界面====================");
            System.out.println("1.查询个人账户信息");
            System.out.println("2.图书管理");
            System.out.println("3.充值记录");
            System.out.println("4.充值");
            System.out.println("5.修改密码");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    selectPersonalAccountInformation();
                    break;
                case "2":
                    userBookManagerMenu();
                    break;
                case "3":
                    selectBalanceRecords();
                    break;
                case "4":
                    reCharge();
                    break;
                case "5":
                    changePassword();
                    break;
                case "0":
                    startMenu();
                default:
                    break;
            }
        }
    }


    //1.查询个人账户信息
    public void selectPersonalAccountInformation(){
        User user = userService.selectById(user_id);
        System.out.println("=====================当前账户信息=====================");
        System.out.println(user);//这里可以在User实体类中重写一下toString()方法
    }

    //5.修改密码
    public void changePassword() throws InterruptedException {
        System.out.println("=====================修改密码界面=====================");
        System.out.println("身份信息验证中......");
        Thread.sleep(2000);
        System.out.println("正在为您生成验证码中......");
        Thread.sleep(2000);

        //PS: 我仿照QQ修改密码的模式加了一个验证码，不过人家是给密保手机发验证码。
        String verificationCode = MyUtil.verificationCodeGeneration();//调用工具类中的验证码生成方法,生成一个四位的验证码。
        System.out.println("请输入验证码: " + verificationCode);
        String verificationInfo = scanner.next();
        //将输入的code和生成随机验证码都转换化为小写，这样输入验证码是就不会区分大小写。
        if (verificationInfo.toLowerCase().equals(verificationCode.toLowerCase())){
            System.out.println("身份信息验证成功......");
            Thread.sleep(1000);
            //这里写update密码的判断逻辑
            //1.判断旧密码是否输入正确  2.判断新密码是否和旧密码相同
            System.out.println("请输入您的旧密码:");
            String oldPassword = scanner.next();
            System.out.println("请输入您的新密码:");
            String newPassword = scanner.next();
            //这个if判断逻辑并没有返回 result, 不属于是业务逻辑。
            if (oldPassword.equals(newPassword)){
                System.out.println("新旧密码不能相同！");
                return;
            }

            int result = userService.updatePasswordById(user_id, oldPassword, newPassword);
            if (result == -1){
                //因为修改密码功能需要用户登录账号成功后才能使用，所以当前的账号是一定存在的。永远不会返回 -1，这里的if判断其实可以省略。
                System.out.println("该账号不存在！");
            }
            if (result == -2){
                System.out.println("旧密码输入错误！");
            }
            if (result == -3){
                System.out.println("新密码不符合要求!");
                System.out.println("1.密码由8-16位数字、字母或符号组成");
                System.out.println("2.至少包含2种以上字符");
            }
            if (result == 1){
                System.out.println("密码修改成功，请重新登录...");
                Thread.sleep(1000);
                loginMenu();
            }
        }else {
            //重新生成新的验证码
            System.out.println("身份验证失败");
            changePassword();//重新验证身份并输入验证码
        }
    }


    //判断密码是否合法的方法
    //新密码做判断要求: 1.密码由8-16位数字、字母或符号组成 2.至少包含2种以上字符
    public boolean isValidPassword(String password) {
        //密码由8-16位数字、字母或符号组成
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLetter = false;//是否包含字母
        boolean hasDigit = false;//是否包含数字
        boolean hasSymbol = false;//是否包含符号

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        //至少包含2种以上字符
        int count = 0;
        if (hasLetter) count++;
        if (hasDigit) count++;
        if (hasSymbol) count++;

        return count >= 2;
    }


    //4.充值功能
    public void reCharge() throws InterruptedException {
        int balance = userService.selectById(user_id).getBalance();//查询当前余额

        System.out.println("=====================充值界面=====================");
        System.out.println("您账户的当前余额为: " + balance + ", 请选择你要充值的金额(输入选项编号):");
        System.out.println("1 -> 10元");
        System.out.println("2 -> 30元");
        System.out.println("3 -> 50元");
        System.out.println("4 -> 其他金额(限额100元)]");
        int rechargeAmount = 0;//初始化充值金额
        choice = scanner.next();
        switch (choice){
            case "1":
                rechargeAmount = 10;
                break;
            case "2":
                rechargeAmount = 30;
                break;
            case "3":
                rechargeAmount = 50;
                break;
            case "4":
                System.out.println("请输入您要充值的金额:");
                rechargeAmount = scanner.nextInt();
                if (rechargeAmount > 100 || rechargeAmount <0){
                    System.out.println("每次的充值金额范围在0~100之间！");
                    return;
                }
                break;
            default:
                System.out.println("您输入的选项不合法！");
                break;
        }

        //充值确认
        //PS：这里我并没有做验证码，因为实际的游戏或软件的充值中，我几乎没有遇见过。
        //站在商家角度，人家巴不得你快点充值！最多就是提醒你是否确认充值！
        System.out.println("确认充值？ 输入'y'继续充值，输入'n'取消充值...");
        String isOrNotRecgange = scanner.next();

        if (isOrNotRecgange.equals("y")){
            int result = userService.updateBalance(user_id, rechargeAmount);//返回充值结果
            if (result == -1){
                System.out.println("该账号不存在！");//同上，这种情况不会发生，可以不写。
            }
            if (result == 1){
                System.out.println("正在为您充值....");
                Thread.sleep(2000);
                System.out.println("充值成功！");
            }
            if (result == 2){
                System.out.println("正在为您充值....");
                Thread.sleep(2000);
                System.out.println("充值成功！");
                Thread.sleep(1000);
                System.out.println("您的等级已经提升！");
            }
            int currentBalance = userService.selectById(user_id).getBalance();
            int currentLevel = userService.selectById(user_id).getLevel();
            System.out.println("本次充值的金额为:"+ rechargeAmount);
            System.out.println("您的当前余额为:" + currentBalance);
            System.out.println("您的等级为:" + currentLevel);
        }

        if (isOrNotRecgange.equals("n")){
            System.out.println("正在为您取消充值...");
            Thread.sleep(1000);
            System.out.println("取消成功！");
        }

    }


    //3.查询充值记录
    public void selectBalanceRecords(){
        //传入自己的user_id即可获取到自己的所有充值记录
        ArrayList<UserAndBalanceRecordsInfo> al = balanceRecordsService.selectBalanceRecordsByUserIdAndBalanceType(user_id);
        if (al.isEmpty()){
            System.out.println("当前账户没有任何充值记录！");
        }else {
            String name = userService.selectById(user_id).getName();
            MyUtil.showList(al, "账户" + name + "的充值记录:");
        }
    }

    //2.用户的图书管理菜单
    public void userBookManagerMenu(){
        while (true) {
            System.out.println("====================用户图书管理界面====================");
            System.out.println("1.查看所有图书");
            System.out.println("2.我的借阅记录");
            System.out.println("3.借阅图书");
            System.out.println("4.归还图书");
            System.out.println("0.退出");
            choice = scanner.next();
            switch (choice){
                case "1":
                    selectAllBook();
                    break;
                case "2":
                    selectMyBorrowRecords();
                    break;
                case "3":
                    borrowBook();
                    break;
                case "4":
                    returnBook();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }


    //查看所有图书
    public void selectAllBook(){
        ArrayList<Book> al = bookService.selectAllBook();
        if (al.isEmpty()){
            System.out.println("没有图书信息！");
        }else {
            MyUtil.showList(al,"所有图书信息");
        }
    }


    //查看我的借阅记录
    public void selectMyBorrowRecords(){
        //获取用户的id
        ArrayList<UserAndBookBorrowRecordsInfo> al = borrowRecordsService.selectMyBorrowRecords(user_id);
        if (al.isEmpty()){
            System.out.println("您没有任何借阅记录！");//搞不懂？还差一步！ 已解决：bookService出错，借书是没有添加记录
        }else {
            MyUtil.showList(al,"我的借阅记录");
        }
    }


    //借阅图书
    public void borrowBook(){
        System.out.println("请输入你要借阅的书籍编号:");//通过查看所有图书功能可以获取所有图书的编号
        int borrow_bid = scanner.nextInt();//注意要输入一个int类型的数据，不然会报错。如何避免？？？
        //调用借书方法并返回int类型结果
        int result = bookService.borrowBook(borrow_bid,user_id);
        if (result == 1){
            System.out.println("借阅成功！");
        }
        if (result == -1){
            System.out.println("不存在该图书！");
        }
        if (result == -2){
            System.out.println("该图书已被借阅，不能重复被借阅！");
        }
    }


    //归还图书
    public void returnBook(){
        System.out.println("请输入你要归还的书籍编号:");
        int return_bid = scanner.nextInt();
        //调用还书方法并返回int类型结果
        int result = bookService.returnBook(return_bid,user_id);
        if (result == 1){
            System.out.println("归还成功！");
        }
        if (result == -1){
            System.out.println("不存在该图书！");
        }
        if (result == -2){
            System.out.println("该图书不可归还！");
        }
    }
    //借阅和归还本质上逻辑是相同的，只是更改图书的状态不同。
    //现在还有一个弊端: 谁都可以借阅和归还，即使人和书对不上号！！！ 已解决：添加一个参数user_id，传入用户编号(user_id)记录是哪个用户借阅和归还的哪本书(bid)


}
