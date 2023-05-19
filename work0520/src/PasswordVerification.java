import java.util.Scanner;

public class PasswordVerification {
    public static void main(String[] args) {
        //使用循环语句实现密码校验
        Scanner password = new Scanner(System.in);
        System.out.println("请输入密码：");
        while (!password.next().equals("123456")){
            System.out.println("密码错误，请重新输入密码！");
        }
        System.out.println("密码输入正确！");
    }
}
