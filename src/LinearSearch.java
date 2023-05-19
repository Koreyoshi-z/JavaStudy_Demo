import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        /*
        题目要求：
        使用数组实现一个 "线性查找法" 。在键盘输入一个数，与指定数组进行查找。
        查找指定的数在数组中出现的位置，找到返回下标，找不到返回-1。

        补充说明：
        线性查找法，即顺序查找。在一列给定的值中进行搜索，从一端开始逐一检查每个元素，直到找到所需元素的过程。
         */

        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要查找的数字: ");
        int number = input.nextInt();
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]){
                index = i+1;
                break;
            }
        }
        if (index != -1){
            System.out.println("您要查找的数字下标为:"+index);
        }else {
            System.out.println("您要查找的数字不存在！");
        }
    }
}
