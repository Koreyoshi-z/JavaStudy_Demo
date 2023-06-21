package com.study.sort;

public class InsertionSort {
    public static void main(String[] args) {
        /*
        插入排序（com.study.sort.InsertionSort）：
                                是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，
                                在已排序序列中从后向前扫描，找到相应位置并插入
        工作原理：
                1.将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
                2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
                （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
         */

        int[] arry = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        for (int i = 1; i <arry.length; i++) {
            int temp = arry[i];
            //保存下标
            int j = i;
            while (j>0 && temp<arry[j-1]){
                arry[j] = arry[j-1];
                j--;
            }
            //插入数据
            arry[j] = temp;
        }
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i]+" ");
        }
    }
}
