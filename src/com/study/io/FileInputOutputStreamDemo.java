package com.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//文件输入与输出流
public class FileInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        File src = new File("D:/CloudMusic/珊瑚海.mp3");//被拷贝的文件路径
        File dat = new File("C:/Users/Hanabi/Desktop/test"+File.separator+ src.getName());//拷贝出来的文件存放的路径
        FileCopyUtil.copyFile(src,dat);
    }
}


//提供一个复制文件的方法用来使用
class FileCopyUtil {
    //src  被拷贝的文件
    //dat  拷贝出来的文件
    public static void copyFile(File src, File dat) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dat);
        long start = System.currentTimeMillis();

        /*
        //一个一个字节地读写，速度太慢。
        int data = -1;
        while ((data = fis.read())!=-1){
            fos.write(data);
        }
        fis.close();
        fos.close();
        */

        //使用缓冲区对读写操作的优化
        int len = 0;
        byte[] buf = new byte[1024*1024];//创建一个缓冲区大小为1M
        while ((len = fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }
        fis.close();
        fos.close();

        long end = System.currentTimeMillis();
        System.out.println("文件拷贝过程总计耗时: "+(end-start)+"毫秒");
    }
}