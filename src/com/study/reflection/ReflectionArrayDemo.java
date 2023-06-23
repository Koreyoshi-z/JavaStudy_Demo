package com.study.reflection;

import java.lang.reflect.Array;

public class ReflectionArrayDemo {
    public static void main(String[] args) throws Exception {
        //使用反射创建一维数组
        Class<?> clazz = Class.forName("java.lang.String");
        Object array1 = Array.newInstance(clazz, 5);
        Array.set(array1,3,"我是一维数组的元素");
        System.out.println(Array.get(array1, 3));

        //使用反射创建二维数组（3行3列）
        int[] dimens = {3,3};
        Object array2 = Array.newInstance(int.class, dimens);
        Object arrayObj = Array.get(array2, 2);//获取第三行（就是一个一维数组） 横坐标
        Array.setInt(arrayObj,2,10);//给指定数组位置附上元素新值  纵坐标
        int[][] arr = (int[][]) array2;
        System.out.println(arr[0][2]);
        System.out.println(arr[1][2]);
        System.out.println(arr[2][2]);
    }
}
