package com.study.reflection;

//获取Class对象的四种方法
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.对象名.getClass()
        Employees employees = new Employees(1,"zhanhsan",23);
        Class<?> classType1 = employees.getClass();
        System.out.println(classType1.getName());
        System.out.println(classType1.getSuperclass().getName());
        //2.类名.class
        Class<?> classType2 = Employees.class;
        System.out.println(classType2.getName());
        System.out.println(classType2.getSuperclass().getName());
        //3.使用Class.forName()；
        try {
            Class<?> classType3 = Class.forName("com.study.reflection.Employees");
            System.out.println(classType3.getName());
            System.out.println(classType3.getSuperclass().getName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //4.使用类的加载器：ClassLoader
        ClassLoader classLoader = ClassDemo.class.getClassLoader();
        Class<?> classType4 = classLoader.loadClass("com.study.reflection.Employees");
        System.out.println(classType4.getName());
        System.out.println(classType4.getSuperclass().getName());


        //获取基本数据类型的Class对象
        Class<?> clazz1 = int.class;
        System.out.println(clazz1.getName());
//      System.out.println(classType4.getSuperclass().getName());

        //通过基本数据类型的包装类来获取对应的基本数据类型所对应的Class
        Class<?> clazz2 = Double.TYPE;
        System.out.println(clazz2.getName());
//      System.out.println(classType5.getSuperclass().getName());

        Class<?> clazz3 = Double.class;
        System.out.println(clazz3.getName());
        System.out.println(clazz3.getSuperclass().getName());
    }
}
class Employees{
    private int id;
    private String name;
    private int age;

    public Employees() {
    }

    public Employees(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}