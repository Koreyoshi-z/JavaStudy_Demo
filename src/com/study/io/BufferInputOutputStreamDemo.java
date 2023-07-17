package com.study.io;

import java.io.*;

public class BufferInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        File src = new File("D:/CloudMusic/珊瑚海.mp3");//被拷贝的文件路径
        //如果存放路径的文件夹不存在就报错 因为Java不会帮你创建，需要你自己手动创建！！！
        File dat = new File("C:/Users/Hanabi/Desktop/test"+File.separator+ src.getName());//拷贝出来的文件存放的路径
        FileCopy.copyFile(src,dat);
    }
}

//提供一个复制文件的方法用来使用
class FileCopy {
    //src  被拷贝的文件
    //dat  拷贝出来的文件
    public static void copyFile(File src, File dat) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dat);
        //创建Buffer缓存类（自带缓存区） 将文件输入输出流包裹
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        long start = System.currentTimeMillis();
        //使用buffer缓冲区对读写操作的优化
        int len = 0;
        while ((len = bis.read())!=-1){
            bos.write(len);
        }
        bis.close();//关闭外部包裹的Buffer缓存类即可
        bos.close();
        long end = System.currentTimeMillis();

        System.out.println("文件拷贝过程总计耗时: "+(end-start)+"毫秒");
    }
}