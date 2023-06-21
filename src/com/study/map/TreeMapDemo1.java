package com.study.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap =new TreeMap<>();
        treeMap.put(1,"张三");
        treeMap.put(2,"李四");
        treeMap.put(1,"法外狂徒");//他会将张三覆盖掉
        treeMap.put(3,"王五");
        treeMap.put(4,"赵六");
        //treeMap.put(null,"我是null");  //将key设置为null，会抛出NullPointerException异常
        System.out.println(treeMap);//按照key升序顺序输出

        //迭代entrySet
        Set<Map.Entry<Integer,String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> next =  it.next();
            System.out.println(next.getKey()+"---"+next.getValue());
        }

    }
}
