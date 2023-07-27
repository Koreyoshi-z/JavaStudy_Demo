package com.study.io;

import java.io.*;

//转换流  InputStreamReader 和 OutputWriter
public class InputOutputStreamReaderWriter {
    public static void main(String[] args) throws Exception {
        //写入
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\Hanabi\\Desktop\\1.txt"),"utf-8");//写入地址和格式
        osw.write("我是一条中文格式的信息");
        osw.close();
        //读取
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Hanabi\\Desktop\\1.txt"));
        String line = null;
        while ((line= br.readLine())!=null){
            System.out.printf(line);
        }
        System.out.printf("\n");
        //读取
        BufferedReader b = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\Hanabi\\Desktop\\1.txt")
        ));
        String li = null;
        while ((li= b.readLine())!=null){
            System.out.printf(li);
        }
    }
}
