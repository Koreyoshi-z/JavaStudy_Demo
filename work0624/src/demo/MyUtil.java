package demo;

import java.util.ArrayList;

public class MyUtil {
    //对集合进行遍历输出的方法
    //msg:表示接下来要输出的数据代表的含义
    public static void showList(ArrayList<Stu> al,String msg){
        System.out.println("=============="+msg+"==============");
        for (Stu stu : al) {
            System.out.println(stu);
        }
    }
}
