package com.study.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
* 需求: 给定一个目录，按照层次来显示目录结构信息，文件名后面请加上*号或文件夹后面加上\来表示
* 要求: 先显示目录在显示文件，
* 运行结果：
*         一级目录
*                二级目录
*                       zzz.gif
*                二级目录
* 123.mp3
* abc.gif
*
* 解题思路:
1.File类里面的ListFile方法遍历文件夹
2.使用List集合
3.递归算法
* */
public class IteratorDirDemo {
    public static void main(String[] args) {
        IteratorUtil.IteratorDir(new File("D:\\FalemonVPN"));
    }
}

class IteratorUtil{

    private static int level = 0;//层级数

    //迭代目录方法
    public static void IteratorDir(File file){
        if (file!=null){
            //先找出递归的出口
            //假设是文件为或文件夹为空就返回
            if (file.isFile()||file.listFiles().length==0){
                return;
            }else {
                File[] files = file.listFiles();//得到一个未排序的数组
                File[] sortedFiles = sort(files);//排序
                for (File f : sortedFiles) {
                    StringBuilder builder = new StringBuilder();
                    if (f.isFile()){
                        builder.append(getTab(level));//追加制表符
                        builder.append(f.getName());
                        builder.append("*");
                    }else {
                        builder.append(getTab(level));//追加制表符
                        builder.append(f.getName());
                        builder.append("\\");//注意："\"是转义字符，会报错。
                    }
                    System.out.println(builder.toString());
                    if (f.isDirectory()){
                        level++;//进入目录遍历，层数加1
                        IteratorDir(f);//递归调用遍历目录的方法
                        level--;//目录数-1，层数-1
                    }
                }
            }
        }
    }

    //文件排序方法
    private static File[] sort(File[] files){
        List<File> fileList = new ArrayList<File>();
        //先存放文件夹
        for (File f : files) {
            if (f.isDirectory()){
                fileList.add(f);
            }
        }
        //在存放文件
        for (File f : files) {
            if (f.isFile()){
                fileList.add(f);
            }
        }
        //把集合中的元素转换成指定大小和类型的数组返回出去
        return fileList.toArray(new File[fileList.size()]);//将ArrayList类型转化为数组类型
    }

    //根据level数来获取"\t"层数
    private static String getTab(int level){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }
    
}