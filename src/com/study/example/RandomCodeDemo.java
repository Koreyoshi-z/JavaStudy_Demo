package com.study.example;

import java.util.Random;

//从(A-G,a-g,0-9)中随机选四位数字，生成一个四位不重复的验证码  例如：Hcx5
//思路：Random  字符数组
public class RandomCodeDemo {
    public static void main(String[] args) {
        System.out.println(RandomCodeGenerate.codeGenerate());
    }
}

class RandomCodeGenerate{
    public static String codeGenerate(){
        String s = "0123456789ABCDEFGabcdefg";
        char[] codeSequence = s.toCharArray(); //将字符串转化为字符类型的数组
        Random random = new Random();
        int count = 0;
        StringBuilder sb = new StringBuilder(); //创建一个可拼接的字符串对象
        while (true){
            int index = random.nextInt(codeSequence.length); //使用Random类生成随机数的下标
            char c = codeSequence[index]; //根据随机生成的下标进一步找到下标对应的字符
            //判断字符串是否重复
            if (sb.indexOf(String.valueOf(c))==-1){ //String.valueOf(c) -> 将c转换为字符串类型
                //这里说明字符c字符没有在sb里存在过，那么就可以追加。
                sb.append(c); //将随机生成的字符c拼接起来
                count++;
                if (count == 4){ //重复生成字符操作执行4次后退出循环
                    break;
                }
            }
        }
        return sb.toString();
    }
}