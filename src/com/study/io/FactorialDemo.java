package com.study.io;

//使用递归方法求阶乘
public class FactorialDemo {
    public static void main(String[] args) {
        System.out.println(FacUtil.getFac(5));
    }
}

class FacUtil{
    //求阶乘
    public static int getFac(int number){
        //退出条件
        if (number == 1){
            return 1;//将最后的getFac(1)返回为1
        }
        return number * getFac(number - 1);
    }
}