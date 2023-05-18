public class MultiplicationTable {
    public static void main(String[] args) {
        //使用双重循环打印九九乘法表
        //外层循环控制打印行数
        for (int i = 1; i <= 9; i++) {
            //内层循环控制打印个数和内容
            for (int j = 1; j <= i; j++) {
                //计算结果
                int result = i*j;
                System.out.print(i + "*" + j + "=" + result + "  ");
            }
            //换行
            System.out.println();
        }
    }
}
