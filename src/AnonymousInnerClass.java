public class AnonymousInnerClass {
    public static void main(String[] args) {
        Person p = new Person();
//        Dog dog = new Dog();
//        p.feed(dog);

        //匿名内部类的用法一
        Animal dog = new Animal(){
            @Override
            void eat() {
                System.out.println("啃骨头");
            }
        };
        p.feed(dog);
        //匿名内部类的用法二
        new Animal(){
            private String name = "旺财";
            public void show(){
                System.out.println("我是匿名内部类的用法");
            }
            @Override
            void eat() {
                System.out.println("啃骨头");
            }
        }.show();
        //匿名内部类的用法三
        p.feed(new Animal(){
            @Override
            void eat() {
                System.out.println("啃鱼");
            }
        });

    }
}

class Person{
    public void feed(Animal animal){
        animal.eat();
    }
}
abstract class Animal{
    abstract void eat();
}


//class Dog extends Animal{
//    @Override
//    void eat() {
//        System.out.println("啃骨头");
//    }
//}

