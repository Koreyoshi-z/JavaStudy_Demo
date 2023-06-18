package topic1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //创建Player对象
        Player player = new Player();

        //创建ArrayList对象
        ArrayList<Player> al = new ArrayList<>();

        //添加4个Player对象
        al.add(new Player(1,"aaa",18));
        al.add(new Player(4,"ccc",23));
        al.add(new Player(2,"bbb",44));
        al.add(new Player(3,"ddd",36));

        //没有调用排序方法之前的排序
        System.out.println("还未排序时......");
        for (Player players : al) {
            System.out.println(players);
        }

        //调用三个排序方法

        //调用按照id属性进行排序的方法
        System.out.println("=========按照id属性进行排序=========");
        player.sortById(al);
        for (Player players : al) {
            System.out.println(players);
        }

        //调用按照name属性进行排序的方法
        System.out.println("=========按照name属性进行排序=========");
        player.sortByName(al);
        for (Player players : al) {
            System.out.println(players);
        }

        //调用按照age属性进行排序的方法
        System.out.println("=========按照age属性进行排序=========");
        player.sortByAge(al);
        for (Player players : al) {
            System.out.println(players);
        }
    }
}
