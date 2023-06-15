//自定义异常
public class CustomException {
    public static void main(String[] args) throws DivideZeroException {
        //步骤四  在方法的调用者处理异常信息
        try {
            int result = divide(10,0);
            System.out.println(result);
        }catch (DivideZeroException e){
            e.printStackTrace();
        }
        System.out.println("程序继续执行...");
    }

    //步骤二  在代码中检测到某个条件成立，需要抛出异常的位置，使用throw语句抛出自定义异常类的实例，
    public static int divide(int a, int b) throws DivideZeroException {
        if (b==0){
            throw new DivideZeroException("除以0异常"); //步骤三  在方法上使用throws语句抛出异常的类型
        }
        return a / b;
    }
}

//步骤一  定义自定义异常类，继承至某个Exception类，重写其中构造方法。
class DivideZeroException extends Exception{
    public DivideZeroException() {
        super();
    }
    public DivideZeroException(String message){
        super(message);
    }
}
