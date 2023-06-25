package demo;

import java.util.Objects;

public class Stu {
    private int id;
    private String name;
    private int age;
    private double grade;
    private String status;

    public Stu(int id) {
        this.id = id;
    }

    public Stu(String name) {
        this.name = name;
    }

    public Stu(int id, String name, int age, double grade, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.status = status;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return id == stu.id && age == stu.age && Double.compare(stu.grade, grade) == 0 && Objects.equals(name, stu.name) && Objects.equals(status, stu.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grade, status);
    }

}
