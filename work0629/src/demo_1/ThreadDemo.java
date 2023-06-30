package demo_1;

//编一个程序，实现两个线程 A 和 B ，A 和 B 同时启动，A线程每隔5秒显示字符串”AAA”，B线程每隔 1秒显示字符‘B’。
public class ThreadDemo {
    public static void main(String[] args) {
        new ThraedA().start();
        new ThraedB().start();
    }
}

//线程A
class ThraedA extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("AAA");
        }
    }
}

//线程B
class ThraedB extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
        }
    }
}