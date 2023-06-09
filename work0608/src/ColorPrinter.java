//定义彩色打印机类
public class ColorPrinter extends Printer{
    @Override
    void print(Student student) {
        System.out.println("彩色打印机: "+student.toString());
    }
}
