package demo_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
    完成下面题目要求
    (1）创建Student类，包含String类型的name，int类型的age，double类型的score，并重写getter、setter等方法。
    (2）创建5个Student对象。已知一个Integer类型的学号对应唯一的一个Student对象
    (3）将5个Student对象保存到HashMap容器中。
    (4）遍历该容器，打印出来。
*/
public class Test {
    public static void main(String[] args) {
        HashMap<Integer,Student> hashMap = new HashMap<>();//Integer类型的数据代表学生的学号
        //向hashMap中添加5条数据
        hashMap.put(1,new Student("Lisa",19,78));
        hashMap.put(2,new Student("Allen",23,88));
        hashMap.put(3,new Student("Raiden",25,55));
        hashMap.put(4,new Student("IU",31,69));
        hashMap.put(5,new Student("Kiwi",16,99));
        //使用entrySet获取hashMap中的所有数据
        Set<Map.Entry<Integer, Student>> entries = hashMap.entrySet();
        //遍历hashMap
        for (Map.Entry<Integer, Student> entry : entries) {
            System.out.println("学号："+entry.getKey()+"，学生信息："+entry.getValue());
        }

    }
}
