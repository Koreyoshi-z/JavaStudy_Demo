//定义主人类
public class Master {
    String name;

    public Master(String name){
        this.name = name;
    }

    public void feedPets(Pet pet,Food food){
        pet.eat(food);
        System.out.println(name+"在喂"+pet.name+"吃"+food.name);
    }
}
