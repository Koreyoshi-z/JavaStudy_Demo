package com.study.io;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterDemo {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\Hanabi\\Desktop\\aaa.txt");
        FileWriter fw = new FileWriter("C:\\Users\\Hanabi\\Desktop\\bbb.txt");
        char[] buff = new char[100];
        int len = 0;//实际读取的字符个数
        while ((len= fr.read(buff))!=-1){
            fw.write(buff,0,len);
        }
        fr.close();
        fw.close();
    }
}
