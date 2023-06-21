package com.study.array;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        /*
        二维数组可以看成以数组为元素的数组
        Java中二维数组的声明和初始化应按照从高维到低维的顺序进行

        示例:
        int[][] arr1 = new int[10][]；//第二维长度未定
        int[][] arr2 = new int[10][20]；//第二维长度确定
        注意：虽然这两个数组的创建有区别，但系统为它们分配的堆内存空间大小是一样的
        原因：对于任何类型的二维数组而言，第一维的大小决定了二维数组对象的大小，因为二维数组的成员是数组引用，数组引用本身大小是固定的
         */

        int[][] array = new int[3][];
        //每个高维的数组指向一个低维的int数组
        array[0] = new int[2];
        array[1] = new int[3];
        array[2] = new int[4];

        //给低维的数组进行赋值
        array[0][0] = 1;
        array[0][1] = 2;
        array[1][0] = 3;
        array[1][1] = 4;
        array[1][1] = 5;
        array[2][0] = 6;
        array[2][1] = 7;
        array[2][2] = 8;
        array[2][3] = 9;

        //输出二维数组的值
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }
}
