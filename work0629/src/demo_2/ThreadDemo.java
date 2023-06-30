package demo_2;

//有5辆火车要过山洞,但确保山洞同时只能有一辆火车通过（过山洞需要2秒），打印输出火车通过的顺序。
//过山洞的顺序是不可控的，只要保证同一时间只有一辆火车能通过山洞即可
//提示：使用线程同步
public class ThreadDemo {
    public static void main(String[] args) {
        Cave cave = new Cave();
        //创建并启动Train线程
        for (int i = 1; i <= 5; i++) {
            Train train = new Train(i,cave);
            train.start();

        }
    }
}

//火车
class Train extends Thread{
    private int trainNumber;//火车号
    private Cave cave;

    public Train(int trainNumber, Cave cave) {
        this.trainNumber = trainNumber;
        this.cave = cave;
    }

    @Override
    public void run() {
        cave.pass(trainNumber);
    }
}

//山洞
class Cave{
    //同步方法 一次只允许一个线程执行
    public synchronized void pass(int trainNumber){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("火车"+trainNumber+"通过山洞");
    }
}