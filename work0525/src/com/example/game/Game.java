package com.example.game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        int option = 0; //选项
        String name = null; //姓名
        String[] names = {"aaa", "bbb", "ccc"}; //用户集
        int len = 0; //数组长度
        int index = -1; //负数，表示数组中不存在
        int score = 0; //成绩
        int[] scores = {0, 1, 2}; //成绩表 保证用户有多少个，成绩也有多少个，并且一一对应
        int userNum; //用户猜的数
        int ranNum = 0; //随机数
        Scanner input = new Scanner(System.in);
        Random ran = new Random();

        //主菜单
        do {
            index = -1; //恢复初始值
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("0.退出");
            System.out.println("请选择：");
            option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("请输入用户名:");
                    name = input.next();
                    //判断用户名是否重复
                    for (int i = 0; i < names.length; i++) {
                        if (name.equals(names[i])){
                            index = i;
                            break;
                        }
                    }
                    //用户名存在
                    if (index != -1){
                        System.out.println("用户名已存在！");
                        continue;
                    }
                    //用户名不存在
                    len = names.length;
                    String[] newName = new String[len+1];
                    for (int i = 0; i < names.length; i++) {
                        newName[i] = names[i];
                    }
                    names = newName;
                    names[len] = name;
                    //成绩数组也要“扩容”
                    int[] newScores = new int[len+1];
                    for (int i = 0; i < scores.length; i++) {
                        newScores[i] = scores[i];
                    }
                    scores = newScores;
                    System.out.println("操作成功！");
                    break;
                case 2:
                    System.out.println("请输入用户名:");
                    name = input.next();

                    for (int i = 0; i < names.length; i++) {
                        if (name.equals(names[i])){
                            index = i;
                            break;
                        }
                    }
                    if (index == -1){
                        System.out.println("用户名不存在！");
                        continue;
                    }
                    System.out.println("登录成功！");
                    do {
                        System.out.println("1.新游戏");
                        System.out.println("2.排行榜");
                        System.out.println("3.返回");
                        option = input.nextInt();
                        switch (option){
                            case 1:
                                ranNum = ran.nextInt(5) + 1; //1~5之间的数
                                for (int i = 0; i < 3; i++) {
                                    System.out.println("请猜数:");
                                    userNum = input.nextInt();
                                    if (userNum == ranNum){
                                        System.out.println("恭喜你，猜对了！");
                                        score++;
                                        break;
                                    }
                                    if (userNum > ranNum){
                                        System.out.println("很遗憾，大了！");
                                        continue;
                                    }
                                    if (userNum < ranNum){
                                        System.out.println("很遗憾，小了！");
                                    }
                                }
                                //更新用户最新位置
                                for (int i = 0; i < names.length; i++) {
                                    if (name.equals(names[i])){
                                        index = i;
                                        break;
                                    }
                                }
                                scores[index]+=score;
                                score = 0; //恢复初始值
                                break;
                            case 2:
                                int stemp = 0; //中间变量
                                String ntemp = null;
                                for (int i = 0; i < scores.length-1; i++) {
                                    for (int j = 0; j < scores.length-1-i; j++) {
                                        if (scores[j]<scores[j+i]){
                                            stemp = scores[j];
                                            scores[j] = scores[j+1];
                                            scores[j+1] = stemp;
                                            //成绩位置发生变化，那相对应的名字的位置也要一起变化
                                            ntemp = names[j];
                                            names[j] = names[j + 1];
                                            names[j + 1] = ntemp;
                                        }
                                    }
                                }
                                //名字和成绩这两个数组大小必须一致
                                for (int i = 0; i < names.length; i++) {
                                    System.out.println(names[i]+"------"+scores[i]);
                                }
                                break;
                            case 3:
                                System.out.println("用户登出...");
                                break;

                            default:
                                System.out.println("输入有误！");
                        }
                    }while (option != 3);
                    break;
                case 0:
                    System.out.println("欢迎━(*｀∀´*)ノ下次再来！");
                    System.exit(0);//关闭JVM
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }while (option!=0);

    }
}
