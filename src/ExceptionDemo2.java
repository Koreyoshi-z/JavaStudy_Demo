public class ExceptionDemo2 {
    public static void main(String[] args) throws Exception {
        Bar bar = new Bar();

        try {
            bar.enter(16);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        try {
            bar.enter(13);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Bar{
    public void enter(int age) throws Exception {
        if (age < 18){
            //非受查时异常
            //受查异常，一定要捕获异常，否则编译都通不过
            //为了规范 throw时候最好throws 声明这个方法是需要捕获异常的
            throw new IllegalArgumentException("年龄不合格！"); //抛出的异常表明向方法传递了一个不合法或不正确的参数
        }else {
            System.out.println("欢迎光临！");
        }
    }
}