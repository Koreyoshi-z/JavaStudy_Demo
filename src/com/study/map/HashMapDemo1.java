package com.study.map;

import java.util.*;

//Map映射
public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"张三");
        hashMap.put(1,"狗蛋");//”狗蛋“将“张三”覆盖
        hashMap.put(2,"李四");
        hashMap.put(3,"王五");
        System.out.println("===================直接输出===================");
        System.out.println(hashMap);


        //获取Map中的所有values
        System.out.println("===================values===================");
        Collection<String> values = hashMap.values();
        for (String value : values) {
            System.out.println(value);
        }

        ///我们还可以得到key的同时去得到所有对应value的值
        System.out.println("===================keySet===================");
        Set<Integer> keys = hashMap.keySet();//这个set集合装的是所有的key
        for (Integer key : keys) {
            System.out.println(key + "---" + hashMap.get(key));
        }

        //hashmap中的键值对数和判空操作
        System.out.println("===================size和isEmpty===================");
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());

        //我们想获取map中所有的键值对，只需要获取所有的Entry对象，接下来调用entry的getKey()和getValue()方法就能获取对应的键值对。
        System.out.println("===================entrySet===================");
        Set<Map.Entry<Integer,String>> entries = hashMap.entrySet();
        //使用增强for循环遍历
        System.out.println("===================foreach===================");
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        System.out.println("===================Iterator===================");
        //使用迭代器也可以  继承了Iterator接口才能使用增强for循环
        Iterator<Map.Entry<Integer,String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> next =  it.next();
            System.out.println(next.getKey() +"---" + next.getValue());
        }

        //hashMap内部的结构是数组链表结构
        //因为不同的key有可能算出来是相同的散列值，根据散列值计算存储到下标位置会有冲突

    }
}
