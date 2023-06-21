package com.study.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //LinkedList内部封装的是一个双向链表数据结构
        //每个节点都是一个Node对象，Node对象里封装的是你要添加的元素,还有一个指向上一个Node对象的引用，和下一个Node对象的引用。

        //不同的容器有不同的数据结构，不同的数据结构操作起来性能也是不一样的
        //链表数据结构做插入和删除的效率比较高，但是查询效率会低

        //数组结构做查询的效率就比较高，因为可以通过下标直接找到对应的元素
        //但是插入和删除效率比较低，因为要做位移操作

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("许七安");
        linkedList.add("萧炎");
        linkedList.add("白小纯");
        linkedList.add("叶辰");
        linkedList.add("薛牧");
        linkedList.addFirst("我是头部");
        linkedList.addLast("我是尾部");
        //使用迭代器遍历
        System.out.println("使用迭代器遍历：");
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println(name);
        }
        //使用增强for循环
        System.out.println("使用增强for循环：");
        for (String name : linkedList) {
            System.out.println(name);
        }
    }
}
