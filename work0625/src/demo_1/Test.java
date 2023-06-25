package demo_1;

import java.util.HashSet;
import java.util.Scanner;

//测试类
public class Test {
    public static void main(String[] args) {
        HashSet<Animal> set = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        //录入5条狗的对象
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第"+(i+1)+"条狗的名字：");
            String name = scanner.next();
            System.out.println("请输入第"+(i+1)+"条狗的年龄：");
            int age = scanner.nextInt();
            System.out.println("请输入第"+(i+1)+"条狗的颜色：");
            String color = scanner.next();

            Dog dog = new Dog(name,age,color);
            set.add(dog);
        }

        //输出去重的信息
        System.out.println("去重后狗的信息：");
        for (Animal animal : set) {
            System.out.println(animal.toString());
        }

    }
}
