import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        //题目要求：从键盘输入一个字符，若为小写字母，则转化为大写字母；若为大写字母，则转化为小写字母；否则转化为ASCII码表中的下一个字符。

        //初始化变量，从键盘输出字符。
        char c;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符:");
        c = input.next().charAt(0);

        //逻辑判断
        if (c>='A'&& c<='Z'){
            c = (char)(c+32);
        }else if (c >= 'a' && c <= 'z'){
            c-=32;
        }else {
            c+=1;
        }

        //输出结果
        System.out.println("字符转换为:"+c);
    }
}