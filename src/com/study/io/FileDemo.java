package com.study.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        //测试File类提供的一些方法
        File file = new File("D:/JavaStudy/test.txt");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isAbsolute());
        System.out.println(file.exists());
        System.out.println(file.getParent());
        file.delete();
        System.out.println(file.exists());
        System.out.println("========================================");

        //创建文件夹和文件
        File file1 = new File("C:/Users/Hanabi/Desktop/test");
        System.out.println(file1.mkdir());//创建文件夹
        File file2 = new File("C:/Users/Hanabi/Desktop/test/test.txt");
        try {
            System.out.println(file2.createNewFile());//创建文件
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("========================================");


        //遍历目标文件夹下的内容
        File file3 = new File("D:/DataBase");
        String[] files = file3.list();
        for (String f : files) {
            System.out.println(f);
        }
        System.out.println("========================================");

        //过滤器筛选想要的文件
        File file4 = new File("D:/DataBase");
        String[] files1 = file4.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");//写我要保留的文件格式
            }
        });
        for (String f : files1) {
            System.out.println(f);
        }

    }
}
