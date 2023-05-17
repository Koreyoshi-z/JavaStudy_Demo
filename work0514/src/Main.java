import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int age;
        char gender;
        double score;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入您的姓名：");
        name = scanner.next();
        System.out.println("请输入您的年龄：");
        age = scanner.nextInt();
        System.out.println("请输入您的性别：");
        gender = scanner.next().charAt(0);
        System.out.println("请输入您的分数：");
        score = scanner.nextDouble();

        System.out.println("您的姓名："+name);
        System.out.println("您的年龄："+age);
        System.out.println("您的性别："+gender);
        System.out.println("您的分数："+score);
    }
}