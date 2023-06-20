import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");
        list.add("jay");
        list.add("zhouzhou");

        System.out.println("原集合数据：");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("自然顺序：");
        Collections.sort(list);
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();

        int index = Collections.binarySearch(list,"jay");//有一定顺序的list才能使用二分查找
        System.out.println("查找元素的下标：" + index);
    }
}
