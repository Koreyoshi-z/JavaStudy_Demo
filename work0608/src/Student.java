//定义学生类
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取学生姓名
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学生年龄
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置学生年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
