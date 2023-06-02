import java.util.Random;
import java.util.Scanner;

public class Demo_2 {
    public static void main(String[] args) {
        //完成以下登录注册系统
        int option = 0; //选项
        String name = null; //姓名
        String[] names = {"admin", "user1", "user2"}; //用户集
        String password = null; //密码
        String[] passwords = {"123456", "111111", "222222"}; //密码集
        String verificationCode = null; //验证码
        int len = 0; //数组长度
        int index = -1; //负数，表示数组中不存在

        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        //主菜单
        do {
            index = -1; //恢复初始值
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.println("请选择：");
            option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("请输入用户名:");
                    name = input.next();
                    for (int i = 0; i < names.length; i++) {
                        if (name.equals(names[i])){
                            index = i;
                            break;
                        }
                    }
                    if (index == -1){
                        System.out.println("用户名不存在！");
                        continue;
                    }

                    System.out.println("请输入密码:");
                    password = input.next();
                    for (int i = 0; i < passwords.length; i++) {
                        if (password.equals(passwords[i])){
                            index = i;
                            break;
                        }
                    }
                    if (index == -1){
                        System.out.println("密码不正确！");
                        continue;
                    }

                    System.out.println("请输入验证码:AjrQjk");
                    verificationCode = input.next();
                    if (verificationCode.equals("AjrQjk")){
                        System.out.println("登录成功！");
                    }else {
                        System.out.println("验证码谁错误！");
                    }
                    break;
                case 2:
                    System.out.println("请输入用户名:");
                    name = input.next();
                    //判断用户名是否重复
                    for (int i = 0; i < names.length; i++) {
                        if (name.equals(names[i])){
                            index = i;
                            break;
                        }
                    }
                    //用户名存在
                    if (index != -1){
                        System.out.println("用户名已存在！");
                        continue;
                    }
                    //用户名不存在
                    len = names.length;
                    String[] newName = new String[len+1];
                    for (int i = 0; i < names.length; i++) {
                        newName[i] = names[i];
                    }
                    names = newName;
                    names[len] = name;
                    break;
                case 3:
                    System.out.println("欢迎━(*｀∀´*)ノ下次再来！");
                    System.exit(0);//关闭JVM
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }while (option!=0);
    }
}
