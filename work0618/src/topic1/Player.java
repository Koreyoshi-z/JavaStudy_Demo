package topic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//创建Player类
public class Player {
    private int id;
    private String name;
    private int age;

    public Player() {
    }

    public Player(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //按照 id 属性进行排序的方法
    public void sortById(ArrayList<Player> players){
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getId() - o2.getId();
            }
        });
    }

    //按照 name 属性进行排序的方法
    public void sortByName(ArrayList<Player> players){
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    //按照 age 属性进行排序的方法
    public void sortByAge(ArrayList<Player> players){
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

}
