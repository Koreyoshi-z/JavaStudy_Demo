import java.util.Scanner;

public class ScoreGradingJudgment {
    public static void main(String[] args) {
        //定义变量和键盘输入
        double score; //成绩
        char level; //等级
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的成绩：");
        score = sc.nextDouble();

        //输入的分数不符合规范
        if (score <0 || score >100){
            System.out.println("分数输入有误！");
            return;
        }

        //分数范围正确
        //每个计f中条件不包含其他if中条件（互斥）
        if (score >= 90 && score <= 100){
            level = 'A';
        } else if (score >= 80) {
            level = 'B';
        } else if (score >= 70) {
            level = 'C';
        } else if (score >=60){
            level = 'D';
        }else {
            level = 'E';
        }

        //输出结果
        System.out.println("你的分数等级为："+ level);
    }
}
