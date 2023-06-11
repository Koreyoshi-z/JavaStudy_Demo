public class LocalInnerCass {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.showOuter();
    }
}

class Outer2{
    private String name = "张三";
    private int num = 10;
    private static int num2 = 20;

    public void showOuter(){
        int num3 = 30; //从jdk1.8开始，其实这里已经是个final类型了
        //局部内部类
        //局部内部类不能加访问修饰符
        class Inner2{
            private int num4 = 40;
            public void showInner(){
                System.out.println(num4);
                System.out.println(Outer2.this.num);
                System.out.println(Outer2.num2);
                System.out.println(num3);
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.showInner();
    }
}