//定义狗类
public class Dog extends Pet{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat(Food food){
        if (food instanceof Bone){
            System.out.println(name+"在吃"+food.getName());
        }else {
            System.out.println(name+"不吃"+food.getName());
        }
    }
}
