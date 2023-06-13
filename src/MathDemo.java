public class MathDemo {
    public static void main(String[] args) {
        long a = Math.round(5.4); //四舍五入
        System.out.println(a);
        double b = Math.floor(5.9); //向下取整
        System.out.println(b);
        double c = Math.sqrt(9.0); //取平方根
        System.out.println(c);
        double d = Math.ceil(5.1); //向上取整
        System.out.println(d);
        int e = Math.abs(-5); //取绝对值
        System.out.println(e);
        double random = Math.random(); //生成一个伪随机数 取值范围[0,1)
        System.out.println(random);
    }
}
