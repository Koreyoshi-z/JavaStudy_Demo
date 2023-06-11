public class EnumDemo {
    public static void main(String[] args) {
        //System.out.println(Color.BLACK);

        Color[] colors = Color.values();
        for (Color c : colors) {
            System.out.println(c.toString());
        }

        System.out.println("----------------------------");

        Person1[] person1 = Person1.values();
        for (Person1 p:person1) {
            System.out.println(p);
        }

        System.out.println("----------------------------");

        Person1 p = Person1.P3;
        switch (p){
            case P1:
                System.out.println(Person1.P1);
                break;
            case P2:
                System.out.println(Person1.P2);
                break;
            case P3:
                System.out.println(Person1.P3);
                break;

        }
    }
}


//当jvm去加载枚举类的时候，会预先创建多个枚举类型的对象

enum Color {
    RED,BLUE,BLACK,YELLOW,GREEN; //枚举类型的值必须作为第一条语句出现
    //上面的语句相当于
    //public static final Color RED = new Color();
    //public static final Color BLUE = new Color();
    //public static final Color BLACK = new Color();
    //public static final Color YELLOW = new Color();
    //public static final Color GREEN = new Color();
    private Color(){
        System.out.println("我是构造器");
    }

    @Override
    public String toString() {
        return "aaa";
    }
}

enum Person1{
    P1("张三",23),P2("李四",24),P3("王五",25);
    //上面的语句相当于
    //public static final Person P1 = new Person2("张三",23);
    //public static final Person P2 = new Person2("张三",23);
    //public static final Person P3 = new Person2("张三",23);

    private String name;
    private int age;

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
