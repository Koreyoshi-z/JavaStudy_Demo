package com.study.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
        String s = "hello world";
        ByteArrayInputStream bis = new ByteArrayInputStream(s.getBytes());
        int data = -1;
        while ((data=bis.read()) != -1){
            System.out.print((char)data);
        }
        //ByteArrayInputStream并没有调用系统本地资源，所以无需关闭
        bis.close();

        System.out.println("\n--------------------------------");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(97);
        bos.write(98);
        bos.write(s.getBytes());
        byte[] buff = bos.toByteArray();
        for (byte b : buff) {
            System.out.print((char)b);
        }

        //FileOutputStream和ByteArrayOutputStream可以配合使用
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hanabi\\Desktop\\职坐标-大数据开发/test.txt");
        //将此 byte 数组输出流的全部内容写入到指定的输出流参数中，这与使用 fos.write(buf, 0, count) 调用该输出流的 write 方法效果一样。
        bos.writeTo(fos);
        fos.close();//FileOutputStream调用了native方法，必须调用close()方法
        bos.close();//ByteArrayOutputStream并没有调用系统本地资源，所以无需关闭
    }
}
