package topic2;

import java.util.ArrayList;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        //创建ArrayList对象
        ArrayList<String> list = new ArrayList<>();
        //向ArrayList对象中添加元素
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张三");
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        //去除ArrayList中的重复元素
        System.out.println("==========去除ArrayList中的重复元素==========");
        //使用双重循环遍历ArrayList，将重复的元素从中移除。
        for (int i = 0; i < list.size()-1; i++) {
            String s = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if (s.equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
        //打印将去重后的列表
        System.out.println(list);
    }
}
