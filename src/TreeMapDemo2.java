import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Person2,String> treeMap =new TreeMap<>(new Comparator<Person2>() {//实现Comparator接口，重写compare方法
            @Override
            public int compare(Person2 o1, Person2 o2) {
                if (o1.getName().compareTo(o2.getName())>0){//先比较字符串
                    return 1;
                }else if (o1.getName().compareTo(o2.getName())<0){
                    return -1;
                }else {
                    return o1.getAge() - o2.getAge();//在比较年龄
                }
            }
        });
        treeMap.put(new Person2("张三",11),"我是第一个人");
        treeMap.put(new Person2("李四",44),"我是第二个人");
        treeMap.put(new Person2("王五",22),"我是第三个人");
        treeMap.put(new Person2("赵六",33),"我是第四个人");
        treeMap.put(new Person2("张三",33),"我是第五个人");
        System.out.println(treeMap);
    }
}

class Person2 /*implements Comparable<Person2>*/{//实现Comparable接口，重写compareTo方法
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
    @Override
    public int compareTo(Person2 o) {
        return this.getAge() - o.getAge();//按照age的升序排序
    }
     */

}