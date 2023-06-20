import java.util.*;

public class CollectionsDemo2 {
    public static void main(String[] args) {
        ArrayList<Student4> stus = new ArrayList<Student4>();
        stus.add(new Student4(1,"zhangsan"));
        stus.add(new Student4(4,"lisi"));
        stus.add(new Student4(6,"zhaoliu"));
        stus.add(new Student4(3,"zhangsan"));
        stus.add(new Student4(5,"wangwu"));
        stus.add(new Student4(2,"erdan"));

        System.out.println("排序前：");
        Iterator<Student4> it = stus.iterator();
        while (it.hasNext()) {
            Student4 stu =  it.next();
            System.out.println(stu);
        }

        System.out.println("排序后：");
        Collections.sort(stus, new Comparator<Student4>() {
            @Override
            public int compare(Student4 o1, Student4 o2) {
                return o1.getId() - o2.getId();
            }
        });

        Iterator<Student4> it1 = stus.iterator();
        while (it1.hasNext()) {
            Student4 stu =  it1.next();
            System.out.println(stu);
        }

    }
}

//使用Collections工具类完成Person的ArrayList集合按照id排序（自然顺序）
class Student4{
    private int id;
    private String name;

    public Student4() {
    }

    public Student4(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}