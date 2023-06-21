package com.study.sort;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        /*
        二分查找法：又称之为折半查找法，适用于已经排好顺序的数组。
        工作原理：
                1.将数组中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；否则利用中间位置记录将数组分成前、后两个子数组，
                2.如果中间位置记录的关键字大于查找关键字，则进一步查找前一子数组，否则进一步查找后一子数组。
                3.重复以上过程，直到找到或找不到为止。
         */

        //在键盘上输入一个值，使用二分查找法查询这个数的位置。
        int[] array = {11, 24, 35, 47, 58, 61 , 73, 85, 99};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要找的数:");
        int number = input.nextInt();
        int index = -1; //index为你要查找的数的位置，-1表示数组中查不到你要找的数。
        int start = 0; //起始下标
        int end = array.length-1; //终止下标
        int middle; //中间位置下标

        while (start <= end){
            //找到中间位置的下标值
            middle = (start+end)/2;
            //当你要查找的数刚好等于中间值
            if (number == array[middle]){
                index = middle + 1;
                break;
            }
            //当你要查找的数大于中间值
            if (number > array[middle]){
                start = middle + 1;
            }
            //当你要查找的数小于中间值
            if (number < array[middle]){
                end = middle - 1;
            }
        }
        if (index != -1){
            System.out.println("你要查找的数在第"+ index +"个位置！");
        }else {
            System.out.println("Not Found!");
        }
    }
}
