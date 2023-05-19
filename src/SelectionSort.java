public class SelectionSort {
    public static void main(String[] args) {
        /*
        选择排序（Selection sort）是一种简单直观的排序算法。
        工作原理：
                1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
                2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
                3.重复第二步，直到所有元素均排序完毕。
         */

        int[] array = {3, 7, 4, 12, 44, 27, 5};
        //保存最小元素下标
        int min = 0;
        //N个数需要比较 N-1 轮
        for (int i = 0; i < array.length-1; i++) {
            min = i;
            //查找最小数在数组中的下标
            for (int j = i+1; j < array.length; j++) {
                if (array[min] > array[j]){
                    min = j; //保存最小数的下标
                }
            }
            //如果第i个最小的数位置不在i上，则进行交换。
            if (i!=min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        //输出选择排序的结果
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
