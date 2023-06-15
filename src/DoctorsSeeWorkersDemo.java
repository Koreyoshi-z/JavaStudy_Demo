//医生给工作者看病案例

import java.util.Random;

//工作者有可能会生病，医生如果发现了工作者生病就给医治
//工作者类，有一个状态代表是否健康
//医生类，治病方法->治好/治不好
//创建自定义异常，当工作者生病的时候就抛出这个异常。
public class DoctorsSeeWorkersDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Doctor doctor = new Doctor();
        try {
            worker.work();
        }catch (SickException e){
            doctor.cure(worker);
            if (worker.getStatus().equals("健康")){
                System.out.println("恭喜您身体恢复健康！");
            }else {
                System.out.println("随不起，我们尽力了！");
            }
        }finally {
            System.out.println("好好工作！");
        }
    }
}

//工作者类
class Worker{
    private String status; //状态

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void work() throws SickException{
        Random random = new Random();
        int ran = random.nextInt(2)+1; //随机生成1和2两个个整数
        if (ran == 1){
            //这里代表有病
            throw new SickException("有病");
        }else {
            System.out.println("身体健康");
        }
    }
}

//医生类
class Doctor{
    //前提是这个worker已经有病了，才给工作者看病。
    public void cure(Worker worker){
        Random random = new Random();
        int ran = random.nextInt(2)+1; //随机生成1和2两个个整数
        if (ran == 1){
            worker.setStatus("健康");
        }else {
            worker.setStatus("死亡");
        }
    }
}

//创建自定义异常
class SickException extends Exception{
    public SickException(String message) {
        super(message);
    }
}