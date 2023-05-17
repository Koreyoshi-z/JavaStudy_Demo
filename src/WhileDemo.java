import java.util.Scanner;

public class WhileDemo {
    public static void main(String[] args) {
        //题目描述：输入一个正整数，把整数逆序输出，比如输入12345，输出54321。

        int number;
        int output;

        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        number = input.nextInt();

        while (number!=0){
            output = number % 10;
            System.out.print(output);
            number/=10;
        }
        //while循环是不确定型循环（循环次数不确定）
    }
}
