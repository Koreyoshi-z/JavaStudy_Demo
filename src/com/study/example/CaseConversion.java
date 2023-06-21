package com.study.example;

import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        //用户输入一个字符，判断字符如果是英文大写则转为小写，如果是英文小写则转为大写，否则不变
        char c;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符:");
        c = input.next().charAt(0);

        //判断字符的大小写，大写转换为小写，小写转换为大写。
        if (c>='A'&& c<='Z'){
            c = (char)(c+32);
            //输出结果
            System.out.println("字符转换为:"+c);
        }else if (c >= 'a' && c <= 'z'){
            c-=32;
            System.out.println("字符转换为:"+c);
        }else {
            System.out.println("输入的字符不符合规范!");
        }
    }
}
