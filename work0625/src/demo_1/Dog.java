package demo_1;

import java.util.Objects;

//狗
public class Dog extends Animal {
    private String color;

    public Dog(String name,int age,String color){
        super(name,age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Dog){
            Dog dog = (Dog) o;
            if (getName().equals(dog.getName())&&getColor().equals(dog.getColor())){
                return true;
            }
        }
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getColor());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", color='" + color + '\'' +
                '}';
    }

}
