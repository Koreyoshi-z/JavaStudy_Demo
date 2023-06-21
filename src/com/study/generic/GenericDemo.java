package com.study.generic;

//泛型类demo
public class GenericDemo {
    public static void main(String[] args) {
        //创建泛型类对象
        GenClass<String> gen1 = new GenClass<String>("wwz");
        System.out.println(gen1.getObj());
        GenClass<Integer> gen2 = new GenClass<Integer>(123);
        System.out.println(gen2.getObj());

        //泛型的类型参数可以是泛型类
        GenClass<Teacher> gen3 = new GenClass<Teacher>(new Teacher("张三")); //将Teacher类作为参数
        GenClass<GenClass<Teacher>> gen4 = new GenClass<GenClass<Teacher>>(gen3);
        System.out.println(gen4.getObj().getObj());

        //测试泛型类是否可以同时设置多个类型参数
        GenClass1<String,Integer> gen5 = new GenClass1<String,Integer>("小蓝",100);
        System.out.println("我是："+gen5.getData1()+"，今年"+gen5.getData2()+"岁了！");

        //测试泛型类是否可以继承泛型类，是否可以实现泛型接口
        SubClass<String,Integer> sub = new SubClass<String,Integer>("胡桃",17);
        System.out.println(sub.showVar()+"---"+sub.showVar2());

        //测试是否可以使用extends关键字限制泛型可用类型
        GenericClass<Dogs> dogs = new GenericClass<Dogs>();
        dogs.setObj(new Dogs());
        dogs.getObj().eat();
        GenericClass<Cats> cats = new GenericClass<Cats>();
        cats.setObj(new Cats());
        cats.getObj().eat();
        //com.study.generic.GenericClass<String> str = new com.study.generic.GenericClass<String>(); //编译不通过

        //泛型通配的方式
        GenericClass<?> f1 = cats; //" ？"代表任意一个类型
        GenericClass<? extends Animals> f2 = cats; //和限制泛型的上限相似，同样可以使用 extends 关键字限定通配符匹配类型的上限
        GenericClass<? super Cats> f3 = cats; //还可以使用 super 关键词将通配符匹配类型限定为某个类型及其父类型

        //泛型方法测试
        GenericMethodDemo gmd = new GenericMethodDemo();
        gmd.print("我是泛型方法");
        gmd.print(new Dogs());
        GenericMethodDemo.printData("我是泛型类的静态方法");
    }
}


//创建一个泛型类
class GenClass<T> {
    private T obj;

    public GenClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

//创建一个Teacher类
class Teacher{
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "我是：" + name;
    }
}

//泛型类可以同时设置多个类型参数
class GenClass1<T1,T2>{
    private T1 data1;
    private T2 data2;

    public GenClass1(T1 data1, T2 data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public T1 getData1() {
        return data1;
    }

    public T2 getData2() {
        return data2;
    }
}

//泛型类可以继承泛型类
//父类泛型类
class SuperClass<T1>{
    private T1 var1;

    public SuperClass(T1 var1) {
        this.var1 = var1;
    }

    public T1 showVar(){
        return var1;
    }
}

//子类泛型类
class SubClass<T1,T2> extends SuperClass<T1> implements Info<T2>{ //泛型类可以实现泛型接口
    private T2 var2;

    public SubClass(T1 var1,T2 var2) {
        super(var1);
        this.var2 = var2;
    }

    @Override
    public T1 showVar() {
        return super.showVar();
    }

    @Override
    public T2 showVar2() {
        return var2;
    }
}

//泛型类接口
interface Info<T2>{
    public T2 showVar2();
}


//限制泛型可用类型-->使用 extends 关键字指定这个类型必须是继承某个类，或者实现某个接口。
//泛型类所接受的参数做了限制，只能接受Animal类型或者Animal类的子类
class GenericClass<T extends Animals>{
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
abstract class Animals{
    public abstract void eat();
}

class Dogs extends Animals{

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

class Cats extends Animals{

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

//什么时候使用泛型方法？
class GenericMethodDemo{
    //泛型方法
    public <T> void print(T content){
        System.out.println(content);
    }
    //方法重载
    public <T extends Animals> void print(T animals){
        animals.eat();
    }
    //静态泛型方法
    public static <T> void printData(T data){
        System.out.println(data);
    }
}


