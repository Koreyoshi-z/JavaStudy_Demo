import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private  int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取学号
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置学号
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取姓名
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
