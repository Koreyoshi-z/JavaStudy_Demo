public class Triangle {
    public static void main(String[] args) {
        //金字塔三角
        //外层循环控制打印行数
        for (int i = 0; i < 5; i++) {
            //打印空格
            for (int j = 5-i; j > 0; j--) {
                System.out.print(" ");
            }
            //打印 *
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            //换行
            System.out.println();
        }
    }
}
