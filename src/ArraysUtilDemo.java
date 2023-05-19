import java.util.Arrays;

public class ArraysUtilDemo {
    public static void main(String[] args) {
        /*
        Arrays类：
        Java的jdk中提供了一个Arrays工具类
        此类专门为程序员操作数组提供了很多专有方法，通过方法的调用可以对数组进行赋值、排序、比较、查找元素等功能。
         */

        //拷贝整个数组
        //copyOf  复制指定的数组，截取或用 0 填充（如有必要），以使副本具有指定的长度
        int[] arraySrc1 = {1, 3, 5, 4, 2, 6};
        int[] arrayDes1 = Arrays.copyOf(arraySrc1,10);
        for (int i = 0; i < arrayDes1.length; i++) {
            System.out.print(arrayDes1[i] + " ");
        }
        System.out.println("\n*******************分割线*********************");

        //拷贝指定数组中的指定范围内的数据
        //copyOfRange  将指定数组的指定范围复制到一个新数组
        int[] arrayDes2 = Arrays.copyOfRange(arraySrc1,2,4);
        for (int i = 0; i < arrayDes2.length; i++) {
            System.out.print(arrayDes2[i] + " ");
        }
        System.out.println("\n*******************分割线*********************");

        //数组的比较
        //equals  比较两个指定的相同的数据类型数组，相等则返回 true。
        int[] arraySrc2 = {3, 1, 5, 4, 2, 6};
        boolean flag = Arrays.equals(arraySrc1,arraySrc2);
        System.out.println(flag);
        System.out.println("*******************分割线*********************");

        //数组的填充
        /*
        fill  将指定的 int 值分配给指定 int 型数组的每个元素。
        将指定的 int 值分配给指定 int 型数组指定范围中的每个元素。
         */

        //将指定的 int 值分配给指定 int 型数组的每个元素。
        int[] arrayDes3 = new int[10];
        Arrays.fill(arrayDes3,10);
        for (int i = 0; i < arrayDes3.length; i++) {
            System.out.print(arrayDes3[i] + " ");
        }
        System.out.println();
        //将指定的 int 值分配给指定 int 型数组指定范围中的每个元素。
        int[] arrayDes4 = new int[10];
        Arrays.fill(arrayDes4,2,6,10); //给数组arrayDes4的下标范围2~6填充值10
        for (int i = 0; i < arrayDes4.length; i++) {
            System.out.print(arrayDes4[i] + " ");
        }
        System.out.println("\n*******************分割线*********************");

        //对数组进行排序
        //sort  默认从小到大排序
        Arrays.sort(arraySrc1);
        for (int i = 0; i < arraySrc1.length; i++) {
            System.out.print(arraySrc1[i] + " ");
        }
        System.out.println("\n*******************分割线*********************");

        //二分法查找
        //binarySearch  使用二分搜索法来搜索指定的类型数组，以获得指定的值。如果找不到指定值，则返回负数。
        int index = Arrays.binarySearch(arraySrc1,5);
        System.out.println(index);
        System.out.println("*******************分割线*********************");

        //使用System这个类的方法来拷贝数组
        int[] arrayDes5 = new int[10];
        System.arraycopy(arraySrc1,0,arrayDes5,2,5);
        //输出arraySrc1数组内容
        for (int i = 0; i < arraySrc1.length; i++) {
            System.out.print(arraySrc1[i] + " ");
        }
        System.out.println();
        //输出arrayDes5数组内容
        for (int i = 0; i < arrayDes5.length; i++) {
            System.out.print(arrayDes5[i] + " ");
        }
    }
}
