public class DoWhileDemo {
    public static void main(String[] args) {
        //题目描述：计算从1开始的连续n个自然数之和，当其和值刚好超过100时结束，求这个n值。

        int n = 0;
        int sum = 0;

        do{
            n++;
            sum+=n;
        }while (sum<=100);

        System.out.println(n);
    }
}
