package com.study.example;

import java.util.Scanner;

public class Calendar2 {
    public static void main(String[] args) {
        /*
        题目要求：
                1.编程计算输入的月份距离1900年1月1日的天数，求出你输入当前月之前的总天数
                2.编程计算输入月份的第一天是星期×，（公式：星期× = 1 + 天数差%7）
                3.格式化输出× ×年× ×月日历（一行输出7个）
        问题设计：使用for循环来计算总天数和打印月份的天数。
         */

        /*
        1.实现从控制台接收年和月，判断是否是闰年
        2.编程计算输入月份所对应的天数
         */
        int year;            //保存输入的年
        int month;           //保存输入的月
        int days = 0;        //保存指定月的天数
        boolean isRn;        //闰年保存true，否则为false
        int totalDays = 0;   //保存总的天数差


        Scanner input = new Scanner(System.in);
        System.out.println("********使用万年历*********");
        System.out.println("请输入年份：");
        year = input.nextInt();
        System.out.println("请输入月份：");
        month = input.nextInt();

        /*
        普通闰年：公历年份是4的倍数且不是100的倍数为普通闰年（如2004、2020年就是闰年）。
        世纪闰年：公历年份是整百数的，必须是400的倍数才是世界闰年（如2000是世纪闰年，1900不是世纪闰年）。
        总结：能被4整除却不能被100整除或能被400整除的年份就是闰年！
         */

        //判断年份是否为闰年
        isRn = (year % 4 == 0 || year % 100 != 0) && year % 400 == 0;

        if (isRn){
            System.out.println(year+"是闰年！");
        }else {
            System.out.println(year+"不是闰年！");
        }


        //计算年的总天数
        for (int i = 1900; i < year; i++) {
            if (i%400==0||((i&4)==0&&i%100!=0)){
                totalDays+=366;
            }else {
                totalDays+=365;
            }
        }

        //计算输入月份之前的天数和
        for (int i = 1; i <= month ; i++) {
            switch (i){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days=31;
                    break;
                case 2:
                    if (isRn){
                        days=29;
                    }else {
                        days=28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days=30;
                default:
                    System.out.println("输入月份有误！");
            }
            //输入月的天数保存到days变量中，但没有累加进去
            if (i!=month){
                totalDays+=days;
            }
        }

        //求出是星期几，其实就是前面的\t的个数
        int beforeDays;
        beforeDays = 1 + totalDays % 7;
        if (beforeDays==7){
            beforeDays = 0;   //代表星期天，0个\t
        }
        System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t");

        //先打印\t
        for (int i = 0; i < beforeDays; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i < days; i++) {
            System.out.print(i+"\t");
            //满7个换行
            if ((i+beforeDays)%7==0){
                System.out.println();
            }
        }
    }
}
