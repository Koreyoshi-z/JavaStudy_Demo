import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        //金字塔三角

        //键入三角形的高度
        int h = 0; //高度
        Scanner input = new Scanner(System.in);
        System.out.println("请输入高度:");
        h = input.nextInt();

        //外层循环控制打印行数
        for (int i = 0; i < 5; i++) {
            //打印空格
            for (int j = h-i; j > 0; j--) {
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
