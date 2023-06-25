package demo_2;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //重写比较规则
                int result = Integer.compare(o1.length(),o2.length());
                if (result == 0){
                    result = o1.compareTo(o2);
                }
                return result;
            }
        });

        //往TreeSet中添加数据
        set.add("xiaoqiang");
        set.add("zhangsan");
        set.add("lisi");
        set.add("xiaohua");
        set.add("ruhua");
        set.add("wangcai");
        System.out.println(set);
    }
}
