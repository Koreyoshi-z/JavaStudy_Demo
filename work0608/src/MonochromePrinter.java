//定义黑白打印机类
public class MonochromePrinter extends Printer{
    @Override
    void print(Student student) {
        System.out.println("黑白打印机: "+student.toString());
    }
}
