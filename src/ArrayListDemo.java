import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        /*
         * 当我们调用无参构造方法来构造一个ArrayList对象的时候，他会在内部分配一个初始大小为10的Object类型的数组
         * 当添加的数据容量超过数组大小的时候，会产生一个新的数组，新的数组大小为原来数组的1.5倍
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("张三");
        arrayList.add("李四");
        arrayList.add("王五");
        arrayList.set(2,"李妙真"); //用指定的元素替代此列表中指定位置上的元素
        //使用迭代器去遍历
        System.out.println("使用迭代器去遍历：");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()){ //判断有没有下一个可迭代的元素
            String name = it.next(); //进来就取出来
            System.out.println(name);
        }
        //使用增强for循环遍历
        System.out.println("使用增强for循环遍历：");
        for (String name : arrayList) {
            System.out.println(name);
        }
        //查找指定位置元素
        System.out.println("查找指定位置元素：");
        System.out.println(arrayList.indexOf("李四")); //返回所要查找元素的位置  1
        System.out.println(arrayList.indexOf("许七安")); //找不到，返回-1
        //返回此列表中的元素数
        System.out.println(arrayList.size());
        //移除此列表中首次出现的指定元素（如果存在）
        arrayList.remove(2);
        System.out.println(arrayList);
    }
}
