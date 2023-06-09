package com.study.sort;

public class BubbleSort {
    public static void main(String[] args) {
        /*
        冒泡排序法：
                冒泡排序（Bubble Sort）也是一种简单直观的排序算法。
                它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
                走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
                这个算法的名字由来是因为越小的元素会经由交换慢慢"浮"到数列的顶端。

        工作原理：
                比较相邻的元素。
                如果第一个比第二个大，就交换它们两个。
                对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
                最后的元素应该会是最大的数。
                针对除了最后一个元素以外所有的元素重复以上的步骤。
                直到没有任何一对数字需要比较。
         */

        int[] array = {3, 7, 4, 12, 44, 27, 5};
        //N个数需要比较 N-1 轮，每一轮比较可以确定一个最大值或最小值
        for (int i = 0; i < array.length-1; i++) {
            //每一轮需要比较的次数为 N-1-i
            for (int j = 0; j < array.length-1-i; j++) {
                //比较相邻两个数，小的数向上冒，大的数向下沉。
                if (array[j] > array[j+1]){
                    //通过设置临时变量，实现交换两个数。
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //输出冒泡排序的结果
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
