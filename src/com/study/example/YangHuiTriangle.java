package com.study.example;

public class YangHuiTriangle {
    public static void main(String[] args) {
        /*
        题目要求：设计打印输出一个8行的杨辉三角形
        输出结果如下：
                    1
                    1 1
                    1 2 1
                    1 3 3 1
                    1 4 6 4 1
                    1 5 10 10 51
                    1 6 15 20 15 6 1
                    1 7 21 35 35 21 7 1
         题目分析：
                 1.找出杨辉三角形特点
                 2.二维数组的声明和使用
                 3.使用for循环来对数组进行赋值和输出
         */


        int row = 8; //行数
        int[][] array = new int[row][row];
        //赋值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                //第一列和对角线列的元素值为1
                if (j==0 || i==j){
                    array[i][j] = 1;
                }else {
                    //其它元素的值是其正上方和其左上方元素的和
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
            }
        }
        //打印输出
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(array[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }
}
