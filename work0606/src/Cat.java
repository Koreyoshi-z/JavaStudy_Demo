//定义鱼类
public class Cat extends Pet{
    public Cat(String name){
        super(name);

    }
    @Override
    public void eat(Food food){
        if (food instanceof Fish){
            System.out.println(name+"在吃"+food.getName());
        }else {
            System.out.println(name+"不吃"+food.getName());
        }
    }
}
