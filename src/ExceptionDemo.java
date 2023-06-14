import java.util.InputMismatchException;
import java.util.Scanner;

//输入一个数字，然后返回结果。
//输入的不是数字时会报错
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("请输入一个数字：");
        Scanner sc = new Scanner(System.in);
        int result = 0;
        try {
            int num = sc.nextInt(); //输入非int类型会抛出InputMismatchException异常
            result = 10 / num; //除数不能为0，即num不等0，否则会发生抛出ArithmeticException异常。
        } catch (InputMismatchException | ArithmeticException e) { //使用 "|" 符号捕获多个异常
            e.printStackTrace(); //将此throwable及其追踪输出至标准错误流
        }catch (Exception e){ //不清楚具体会抛出什么异常的情况，可以在catch()中传入Exception,这样可以保证不会出错。
            e.printStackTrace();
        }finally { //除非在之前执行System.exit(0)，否则必走finally语句块。
            System.out.println("结果为：" + result);
        }

        System.out.println("--------------分割线-------------");
        testFinally("小明");
    }

    //try和finally可以一起使用
    private static void testFinally(String name){
        try {
            System.out.println(name.length());
        }finally {
            System.out.println("finally");
        }
    }
}
