//定义测试类
public class Test {
    public static void main(String[] args) {
        Master master = new Master("小明");
        Pet dog = new Dog("旺财");
        Pet cat = new Cat("小花");
        Food bone = new Bone();
        Food fish = new Fish();
        master.feedPets(dog,bone);
        master.feedPets(dog,fish);
        master.feedPets(cat,fish);
        master.feedPets(cat,bone);
    }
}