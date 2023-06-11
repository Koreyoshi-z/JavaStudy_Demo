public class InnerClass {
    public static void main(String[] args) {
        //创建外部类
        Outer outer = new Outer();
        //创建了内部类的对象inner
        Outer.Inner inner = outer.new Inner();
        inner.innerShow();
    }

}
class Outer {
    private String name = "张三";
    private int num = 111;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num);
    }
    class Inner {
        private String name = "李四";
        private int num = 222;
        //在成员内部类中不能声明static类型的属性或方法
        private static final int num1 = 333;//常量可以
        public void innerShow(){
            System.out.println(name);
            System.out.println(num);
            System.out.println(num1);
        }
    }
}
