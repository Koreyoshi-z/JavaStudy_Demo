public class MaxMinDemo {
    public static void main(String[] args) {
        //求数组中的最大值，最小值。
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        //将数组的第一个元素设置为最大值
        int max = array[0];
        //将数组的第一个元素设置为最小值
        int min = array[0];
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            //从前往后遍历过程中，两两相比，将大的数赋值给max
            if (array[i] > max){
                max = array[i];
            }
            //从前往后遍历过程中，两两相比，将小的数赋值给min
            if (array[i] < min){
                min = array[i];
            }
        }

        //输出结果
        System.out.println("最大值为："+max);
        System.out.println("最小值为："+min);
    }
}
