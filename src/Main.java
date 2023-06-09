public class Main {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setId(123456);
        stu.setName("小明");
        stu.setAge(18);
        Student stu2 = new Student();
        stu2.setId(123456);
        stu2.setName("小明");
        stu2.setAge(18);
        System.out.println(stu.toString());
        System.out.println(stu2.toString());
        System.out.println(stu.equals(stu2));
    }
}