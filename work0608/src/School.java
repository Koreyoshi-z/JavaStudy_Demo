//定义学校类
public class School {
    public static void main(String[] args) {
        //创建学生实例
        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(15);

        Student stu2 = new Student();
        stu2.setName("小蓝");
        stu2.setAge(18);

        //创建打印机实例 打印学生信息
        Printer colorPrinter = new ColorPrinter();
        colorPrinter.print(stu1);

        Printer mchromePrinter = new MonochromePrinter();
        mchromePrinter.print(stu2);
    }
}