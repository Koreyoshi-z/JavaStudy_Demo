public class AutomaticBoxingAndUnboxing {
    public static void main(String[] args) {
        //自动装箱
        int i = 10;
        Integer num = i;
        System.out.println(num);
        System.out.println(num.MAX_VALUE);
        //自动拆箱
        int j = num; //相当于 int j = num.intValue();
        System.out.println(j);

        Object o = i; //i自动装箱成了Integer
        System.out.println(o);
    }
}
