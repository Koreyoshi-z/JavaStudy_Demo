import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        //题目要求：从键盘输入自己的姓名和年龄并打印出来

        //定义变量去接受姓名和年龄
        String name;
        int age;

        //在控制台输入姓名和年龄
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名:");
        name = sc.next();
        System.out.println("请输入你的年龄:");
        age = sc.nextInt();

        //控制台输出结果
        System.out.println("姓名:"+name);
        System.out.println("年龄:"+age);
    }
}
