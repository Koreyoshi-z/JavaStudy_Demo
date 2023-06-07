//定义宠物类
public class Pet {
    String name;

    public Pet(String name){
        this.name = name;
    }

    public void eat(Food food){
        System.out.println(name+"在吃"+food);
    }
}
